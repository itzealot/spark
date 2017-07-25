package com.sky.project.share.streaming.analysis;

import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFlatMapFunction;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ga.projects.spark.process.entity.CertificationTrack;

import scala.Tuple2;

/**
 * CertificationTracksMergeProcess
 * 
 * @author zealot
 */
@SuppressWarnings("serial")
public class CertificationTrackMergeProcess {

	static final Logger LOG = LoggerFactory.getLogger(CertificationTrackMergeProcess.class);

	static final int MERGE_TIME_RANGE = 300;

	public JavaDStream<CertificationTrack> flatMap(JavaDStream<String[]> stream) {
		return stream.flatMapToPair(new PairFlatMapFunction<String[], String, CertificationTrack>() {
			@Override
			public Iterable<Tuple2<String, CertificationTrack>> call(String[] t) throws Exception {
				// TODO
				// key : id + "|" + idType + "|" + serviceCode
				// value: CertificationTracks
				return null;
			}
		}).reduceByKey(new Function2<CertificationTrack, CertificationTrack, CertificationTrack>() {
			@Override
			public CertificationTrack call(CertificationTrack v1, CertificationTrack v2) throws Exception {
				Long startTime1 = v1.getStartTime();
				Long endTime1 = v1.getEndTime();

				Long startTime2 = v2.getStartTime();
				Long endTime2 = v2.getEndTime();

				CertificationTrack big = v1;
				if (endTime2 > endTime1) {
					big = v2;
				}

				// 在时间范围内，时间合并
				if (Math.abs(startTime1 - endTime2) <= MERGE_TIME_RANGE
						|| Math.abs(startTime2 - endTime1) <= MERGE_TIME_RANGE) {
					long min = Math.min(startTime1, startTime2);
					long max = Math.max(endTime1, endTime2);
					big.setStartTime(min);
					big.setEndTime(max);

					int lingerTime = (int) (max - min);
					big.setLingerTime(lingerTime);
					if (big.getMaxLingerTime() < lingerTime) {
						big.setMaxLingerTime(lingerTime);
					}
				} else {
					big.setTimes(big.getTimes() + 1); // 次数加1
				}

				return big;
			}
		}).map(new Function<Tuple2<String, CertificationTrack>, CertificationTrack>() {
			@Override
			public CertificationTrack call(Tuple2<String, CertificationTrack> v1) throws Exception {
				return v1._2;
			}
		});
	}

}

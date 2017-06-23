package com.ga.projects.spark.process.processor.impl;

import org.apache.spark.streaming.api.java.JavaDStream;

import com.ga.projects.spark.process.StreamingKafkaContext;
import com.ga.projects.spark.process.message.MessageParser;

@SuppressWarnings("serial")
public class AllTrackStreamProcess extends BaseStreamProcess {

	public AllTrackStreamProcess() {
		super();
	}

	@Override
	protected void persistOthers(StreamingKafkaContext<String[]> context, MessageParser parser) {
		JavaDStream<String[]> stream = context.getStream();

		// 分析AllTracks并入库
		if (stream != null && parser != null && parser.isPersistAllTrack()) {
			if (!parser.isMergeAllTrack()) {
				persistAllTrack(stream, parser);
			} else {
				persistAllTrackWithMerge(stream, parser);
			}
		}
	}

	protected final void persistAllTrack(JavaDStream<String[]> stream, MessageParser parser) {
	}

	protected final void persistAllTrackWithMerge(JavaDStream<String[]> stream, MessageParser parser) {
	}
}

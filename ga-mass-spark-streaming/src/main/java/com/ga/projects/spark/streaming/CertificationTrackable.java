package com.ga.projects.spark.streaming;

import java.io.Serializable;

import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;

public interface CertificationTrackable extends Serializable {

	/**
	 * 分析身份轨迹
	 * 
	 * @param stream
	 * @return
	 */
	JavaPairDStream<String, String[]> analysisCertificationTrack(JavaDStream<String[]> stream);

	/**
	 * 是否持久化身份轨迹
	 * 
	 * @return
	 */
	boolean isPersistCertificationTrack();

}

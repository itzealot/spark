package com.ga.projects.spark.streaming;

import java.io.Serializable;

import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;

public interface AllTrackable extends Serializable {

	/**
	 * 分析AllTrack
	 * 
	 * @param stream
	 * @return
	 */
	JavaPairDStream<String, String[]> analysisAllTrack(JavaDStream<String[]> stream);

	/**
	 * 是否持久化AllTrack
	 * 
	 * @return
	 */
	boolean isPersistAllTrack();
}

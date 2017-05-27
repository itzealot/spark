package com.ga.projects.spark.process;

import java.io.Serializable;

import org.apache.spark.streaming.api.java.JavaDStream;

public interface AllTrackable extends Serializable {

	/**
	 * 分析AllTrack
	 * 
	 * @param stream
	 * @return
	 */
	JavaDStream<String[]> analysisAllTrack(JavaDStream<String[]> stream);

	/**
	 * 是否持久化AllTrack
	 * 
	 * @return
	 */
	boolean isPersistAllTrack();

	/**
	 * all_track是否进行合并
	 * 
	 * @return
	 */
	boolean isMergeAllTrack();
}

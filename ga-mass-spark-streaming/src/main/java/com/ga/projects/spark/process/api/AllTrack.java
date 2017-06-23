package com.ga.projects.spark.process.api;

import java.io.Serializable;

import org.apache.spark.streaming.api.java.JavaDStream;

import com.ga.projects.spark.process.message.MessageParser;

@FunctionalInterface
public interface AllTrack extends Serializable {

	/**
	 * 分析AllTrack
	 * 
	 * @param stream
	 * @return
	 */
	JavaDStream<String[]> analysisAllTrack(JavaDStream<String[]> stream, MessageParser parser);

	/**
	 * 是否持久化AllTrack
	 * 
	 * @return
	 */
	default boolean isPersistAllTrack() {
		return true;
	}

	/**
	 * all_track是否进行合并
	 * 
	 * @return
	 */
	default boolean isMergeAllTrack() {
		return false;
	}
}

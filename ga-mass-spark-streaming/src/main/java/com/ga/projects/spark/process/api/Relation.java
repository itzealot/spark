package com.ga.projects.spark.process.api;

import java.io.Serializable;

import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;

import com.ga.projects.spark.process.message.MessageParser;

public interface Relation extends Serializable {

	/**
	 * 分析Relation
	 * 
	 * @param stream
	 * @return
	 */
	JavaPairDStream<String, String[]> analysisRelation(JavaDStream<String[]> stream, MessageParser parser);

	/**
	 * 是否持久化Relation
	 * 
	 * @return
	 */
	default boolean isPersistRelation() {
		return true;
	}
}

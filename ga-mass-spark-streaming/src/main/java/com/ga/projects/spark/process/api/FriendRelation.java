package com.ga.projects.spark.process.api;

import java.io.Serializable;

import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;

import com.ga.projects.spark.process.message.MessageParser;

@FunctionalInterface
public interface FriendRelation extends Serializable {

	/**
	 * 分析FriendRelation
	 * 
	 * @param stream
	 * @return
	 */
	JavaPairDStream<String, String[]> analysisFriendRelation(JavaDStream<String[]> stream, MessageParser parser);

	/**
	 * 是否持久化FriendRelation
	 * 
	 * @return
	 */
	default boolean isPersistFriendRelation() {
		return true;
	}
}

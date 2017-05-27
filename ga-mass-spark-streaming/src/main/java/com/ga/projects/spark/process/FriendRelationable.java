package com.ga.projects.spark.process;

import java.io.Serializable;

import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;

public interface FriendRelationable extends Serializable {

	/**
	 * 分析FriendRelation
	 * 
	 * @param stream
	 * @return
	 */
	JavaPairDStream<String, String[]> analysisFriendRelation(JavaDStream<String[]> stream);

	/**
	 * 是否持久化FriendRelation
	 * 
	 * @return
	 */
	boolean isPersistFriendRelation();
}

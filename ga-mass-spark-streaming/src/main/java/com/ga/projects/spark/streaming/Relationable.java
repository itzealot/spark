package com.ga.projects.spark.streaming;

import java.io.Serializable;

import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;

public interface Relationable extends Serializable {

	/**
	 * 分析Relation
	 * 
	 * @param stream
	 * @return
	 */
	JavaPairDStream<String, String[]> analysisRelation(JavaDStream<String[]> stream);

	/**
	 * 是否持久化Relation
	 * 
	 * @return
	 */
	boolean isPersistRelation();
}

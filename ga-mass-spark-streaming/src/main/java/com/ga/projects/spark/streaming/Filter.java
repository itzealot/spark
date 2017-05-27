package com.ga.projects.spark.streaming;

import java.io.Serializable;

import org.apache.spark.streaming.api.java.JavaDStream;

public interface Filter<T extends Serializable> extends Serializable {

	/**
	 * 过滤
	 * 
	 * @param stream
	 * @return
	 */
	JavaDStream<T> filter(JavaDStream<T> stream);

	/**
	 * 是否过滤
	 * 
	 * @return
	 */
	boolean isFilter();
}

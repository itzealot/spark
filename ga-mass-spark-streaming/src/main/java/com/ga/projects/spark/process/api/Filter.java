package com.ga.projects.spark.process.api;

import java.io.Serializable;

import org.apache.spark.streaming.api.java.JavaDStream;

/**
 * Filter Function
 * 
 * @author zealot
 *
 * @param <T>
 */
@FunctionalInterface
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
	default boolean isFilter() {
		return true;
	}
}

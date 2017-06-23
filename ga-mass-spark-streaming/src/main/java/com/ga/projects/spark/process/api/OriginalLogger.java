package com.ga.projects.spark.process.api;

import java.io.Serializable;

import org.apache.spark.streaming.api.java.JavaDStream;

/**
 * 
 * 
 * @author zealot
 *
 * @param <T>
 */
@FunctionalInterface
public interface OriginalLogger<T> extends Serializable {

	/**
	 * 持久化原始日志
	 * 
	 * @param stream
	 */
	void persistOriginalLog(JavaDStream<T> stream);

	/**
	 * 是否持久化原始日志
	 * 
	 * @return
	 */
	default boolean isPersistOriginalLog() {
		return true;
	}
}

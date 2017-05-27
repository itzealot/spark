package com.ga.projects.spark.process;

import java.io.Serializable;

import org.apache.spark.streaming.api.java.JavaDStream;

public interface OriginalLogger<T extends Serializable> extends Serializable {

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
	boolean isPersistOriginalLog();
}

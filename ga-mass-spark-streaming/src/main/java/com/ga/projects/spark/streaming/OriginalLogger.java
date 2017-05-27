package com.ga.projects.spark.streaming;

import java.io.Serializable;

import org.apache.spark.streaming.api.java.JavaDStream;

public interface OriginalLogger<T extends Serializable> extends Serializable {

	/**
	 * 是否持久化
	 * 
	 * @param stream
	 */
	void persist(JavaDStream<T> stream);

	/**
	 * 是否持久化Certification
	 * 
	 * @return
	 */
	boolean isPersistOriginalLog();
}

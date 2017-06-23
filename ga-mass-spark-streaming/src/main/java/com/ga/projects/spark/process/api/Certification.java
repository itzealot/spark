package com.ga.projects.spark.process.api;

import java.io.Serializable;

import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;

import com.ga.projects.spark.process.message.MessageParser;


/**
 * Certification
 * 
 * @author zealot
 *
 */
@FunctionalInterface
public interface Certification extends Serializable {

	/**
	 * 分析Certification
	 * 
	 * @param stream
	 * @return
	 */
	JavaPairDStream<String, String[]> analysisCertification(JavaDStream<String[]> stream, MessageParser parser);

	/**
	 * 是否持久化Certification
	 * 
	 * @return
	 */
	default boolean isPersistCertification() {
		return true;
	}
}

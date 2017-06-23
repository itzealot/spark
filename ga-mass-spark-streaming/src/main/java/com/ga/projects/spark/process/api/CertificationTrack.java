package com.ga.projects.spark.process.api;

import java.io.Serializable;

import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;

import com.ga.projects.spark.process.message.MessageParser;

@FunctionalInterface
public interface CertificationTrack extends Serializable {

	/**
	 * 分析身份轨迹
	 * 
	 * @param stream
	 * @return
	 */
	JavaPairDStream<String, String[]> analysisCertificationTrack(JavaDStream<String[]> stream, MessageParser parser);

	/**
	 * 是否持久化身份轨迹
	 * 
	 * @return
	 */
	default boolean isPersistCertificationTrack() {
		return true;
	}

}

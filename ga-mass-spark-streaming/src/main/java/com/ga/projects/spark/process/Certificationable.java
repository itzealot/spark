package com.ga.projects.spark.process;

import java.io.Serializable;

import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;

public interface Certificationable extends Serializable {

	/**
	 * 分析Certification
	 * 
	 * @param stream
	 * @return
	 */
	JavaPairDStream<String, String[]> analysisCertification(JavaDStream<String[]> stream);

	/**
	 * 是否持久化Certification
	 * 
	 * @return
	 */
	boolean isPersistCertification();
}

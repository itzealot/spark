package com.ga.projects.spark.process;

import java.io.Serializable;
import java.util.Map;

import org.apache.spark.streaming.api.java.JavaDStream;

/**
 * StreamingKafkaContext
 * 
 * @author zealot
 *
 * @param <T>
 * @param <V>
 */
public interface StreamingKafkaContext<T> extends Serializable {

	/**
	 * get Stream
	 * 
	 * @return
	 */
	JavaDStream<T> getStream();

	/**
	 * get parameters map
	 * 
	 * @return
	 */
	Map<String, String> getParams();

	Map<String, String> getCertProtocolMap();

	Map<String, String> getMacHasCompanyMap();

}

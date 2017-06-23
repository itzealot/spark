package com.ga.projects.spark.process.loader;

import java.io.Serializable;
import java.util.Map;

import org.apache.spark.streaming.api.java.JavaStreamingContext;

import com.ga.projects.spark.process.StreamingKafkaContext;
import com.ga.projects.spark.process.message.MessageConverter;

/**
 * StreamingKakfaLoader
 * 
 * @author zealot
 *
 * @param <T>
 */
public interface StreamingKakfaLoader<T> extends Serializable {

	/**
	 * load kafka stream
	 * 
	 * @param jssc
	 * @param kafkaParams
	 * @param topic
	 * @param partionAndOffset
	 */
	StreamingKafkaContext<T> kafkaLoad(JavaStreamingContext jssc, Map<String, String> kafkaParams, String topic,
			Map<Integer, Long> partionAndOffset, MessageConverter<T> converter);
}

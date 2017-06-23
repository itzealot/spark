package com.ga.projects.spark.process;

import java.io.Serializable;

import com.ga.projects.spark.process.message.MessageParser;
import com.ga.projects.spark.process.processor.BaseProcessor;

/**
 * StreamingRunnable
 * 
 * @author zealot
 *
 * @param <T>
 */
public interface StreamingKafkaRunnable<T> extends Serializable {

	/**
	 * deal
	 * 
	 * @param processor
	 * @param parser
	 */
	void deal(StreamingKafkaContext<T> context, BaseProcessor<T> processor, MessageParser parser);
}

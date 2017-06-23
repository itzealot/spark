package com.ga.projects.spark.process.processor;

import java.io.Serializable;

import com.ga.projects.spark.process.StreamingKafkaContext;
import com.ga.projects.spark.process.api.OriginalLogger;
import com.ga.projects.spark.process.message.MessageParser;

/**
 * Executor
 * 
 * @author zealot
 *
 * @param <T>
 */
public interface BaseProcessor<T> extends Serializable {

	BaseProcessor<T> register(OriginalLogger<T> originalLogger);

	/**
	 * 启动程序进行消费
	 * 
	 * @param context
	 * @param parser
	 */
	void start(StreamingKafkaContext<T> context, MessageParser parser);

}
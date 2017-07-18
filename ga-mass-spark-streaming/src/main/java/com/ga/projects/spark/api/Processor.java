package com.ga.projects.spark.api;

import java.io.Serializable;

/**
 * Processor
 * 
 * @author zealot
 * @param <T>
 */
public interface Processor<T> extends Serializable {

	/**
	 * 启动程序进行消费
	 * 
	 * @param parser
	 */
	void process(MessageParser parser);

}

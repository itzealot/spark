package com.ga.projects.spark.process.message;

/**
 * MessageConverter
 * 
 * @author zealot
 *
 * @param <T>
 */
public interface MessageConverter<T> {

	/**
	 * convert message to object
	 * 
	 * @param line
	 * @return
	 */
	T convert(String line);

	/**
	 * validate message
	 * 
	 * @param message
	 * @return
	 */
	boolean validate(T message);

	/**
	 * update message
	 * 
	 * @param message
	 * @return
	 */
	T update(T message);
}

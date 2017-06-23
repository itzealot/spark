package com.ga.projects.spark.process.support;

import java.util.HashMap;
import java.util.Map;

import com.ga.projects.spark.process.message.MessageParser;

/**
 * MessageParserHolder
 * 
 * @author zealot
 *
 */
public final class MessageParserHolder {

	private static Map<Class<?>, MessageParser> parsers = new HashMap<>();

	static {
		// Add parsers
	}

	public static MessageParser get(Class<?> clazz) {
		return parsers.get(clazz);
	}

	private MessageParserHolder() {
	}
}

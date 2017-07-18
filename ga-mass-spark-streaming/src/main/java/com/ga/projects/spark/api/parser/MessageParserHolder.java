package com.ga.projects.spark.api.parser;

import java.util.HashMap;
import java.util.Map;

import com.ga.projects.spark.api.DataType;
import com.ga.projects.spark.api.MessageParser;

/**
 * MessageParserHolder
 * 
 * @author zealot
 */
public final class MessageParserHolder {

	private static Map<DataType, MessageParser> parsers = new HashMap<>();

	static {
		// Add all parsers
	}

	public static MessageParser get(DataType dataType) {
		return parsers.get(dataType);
	}

	private MessageParserHolder() {
	}
}

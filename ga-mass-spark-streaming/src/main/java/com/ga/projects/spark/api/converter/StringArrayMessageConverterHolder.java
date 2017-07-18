package com.ga.projects.spark.api.converter;

import java.util.HashMap;
import java.util.Map;

import com.ga.projects.spark.api.DataType;

/**
 * StringArrayMessageConverterHolder
 * 
 * @author zealot
 */
public final class StringArrayMessageConverterHolder {

	private static final Map<DataType, StringArrayMessageConverter> converters = new HashMap<>();

	static {
		// Add converters
	}

	public static StringArrayMessageConverter get(DataType dataType) {
		return converters.get(dataType);
	}

	private StringArrayMessageConverterHolder() {
	}
}

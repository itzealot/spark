package com.ga.projects.spark.process;

import java.util.Map;

import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;

public interface StreamKafkaLoader<T> {

	JavaDStream<T> getStream();

	void kafkaLoad(JavaStreamingContext jssc, Map<String, String> kafkaParams, String topic,
			Map<Integer, Long> partionAndOffset);

	Map<String, String> getParams();

	Map<String, String> getCertProtocolMap();

	Map<String, String> getMacHasCompanyMap();
}

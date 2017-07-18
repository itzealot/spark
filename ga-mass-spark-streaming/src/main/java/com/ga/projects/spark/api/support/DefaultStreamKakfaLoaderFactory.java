package com.ga.projects.spark.api.support;

import java.util.Map;

import org.apache.spark.SparkConf;
import org.apache.spark.broadcast.Broadcast;

import com.ga.projects.spark.api.StreamKakfaLoader;
import com.ga.projects.spark.api.StreamKakfaLoaderFactory;

public class DefaultStreamKakfaLoaderFactory implements StreamKakfaLoaderFactory<String[]> {

	@Override
	public StreamKakfaLoader<String[]> getLoader(SparkConf conf,
			Map<String, Broadcast<Map<String, String>>> broadcastRedisMap,
			Map<String, Broadcast<String>> broadcastMap) {
		return new DefaultStreamKafkaLoader<>(conf, broadcastRedisMap, broadcastMap);
	}

}

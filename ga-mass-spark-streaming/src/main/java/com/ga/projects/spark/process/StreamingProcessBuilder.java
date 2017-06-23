package com.ga.projects.spark.process;

import java.io.Serializable;
import java.util.Map;

import org.apache.spark.SparkConf;
import org.apache.spark.broadcast.Broadcast;
import org.apache.spark.streaming.api.java.JavaStreamingContext;

import com.ga.projects.spark.process.message.MessageConverter;
import com.ga.projects.spark.process.message.MessageParser;
import com.ga.projects.spark.process.processor.BaseProcessor;
import com.ga.projects.spark.process.processor.impl.BaseStreamProcess;
import com.ga.projects.spark.process.support.StreamKafkaLoaderImpl;

/**
 * StreamingProcessBuilder
 * 
 * @author zealot
 *
 */
@SuppressWarnings("serial")
public class StreamingProcessBuilder implements Serializable {

	private Map<String, Broadcast<Map<String, String>>> broadcastRedisMap;
	private Map<String, Broadcast<String>> broadcastMap;
	private JavaStreamingContext jssc;
	private String streamingType;
	private SparkConf conf;

	// default Executor is BaseStreamProcess
	private BaseProcessor<String[]> processor = new BaseStreamProcess();
	private MessageParser parser;

	public StreamingProcessBuilder(JavaStreamingContext jssc, SparkConf conf,
			Map<String, Broadcast<Map<String, String>>> broadcastRedisMap, Map<String, Broadcast<String>> broadcastMap,
			String streamingType) {
		this.conf = conf;
		this.broadcastRedisMap = broadcastRedisMap;
		this.broadcastMap = broadcastMap;
		this.jssc = jssc;
		this.streamingType = streamingType;
	}

	public StreamingProcessBuilder register(BaseProcessor<String[]> executor) {
		this.processor = executor;
		return this;
	}

	public StreamingProcessBuilder register(MessageParser parser) {
		this.parser = parser;
		return this;
	}

	public void start(Map<String, String> kafkaParams, String topic, Map<Integer, Long> partionAndOffset,
			MessageConverter<String[]> converter) {

		StreamingKafkaContext<String[]> context = new StreamKafkaLoaderImpl<String[]>(conf, broadcastRedisMap,
				broadcastMap, streamingType).kafkaLoad(jssc, kafkaParams, topic, partionAndOffset, converter);

		// StreamingRunnable
		new StreamingKafkaRunnable<String[]>() {
			@Override
			public void deal(StreamingKafkaContext<String[]> context, BaseProcessor<String[]> processor,
					MessageParser parser) {
				processor.start(context, parser);
			}
		}.deal(context, processor, parser);
	}

}

package com.ga.projects.spark.process.support;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.broadcast.Broadcast;
import org.apache.spark.serializer.KryoSerializer;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.apache.spark.streaming.kafka.KafkaUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ga.projects.spark.conf.SysContans;
import com.ga.projects.spark.process.StreamingKafkaContext;
import com.ga.projects.spark.process.loader.StreamingKakfaLoader;
import com.ga.projects.spark.process.message.MessageConverter;
import com.ga.projects.spark.support.StreamHelper;

import kafka.message.MessageAndMetadata;
import kafka.serializer.StringDecoder;

/**
 * StreamKafkaLoaderImpl for loading Stream
 * 
 * @author zealot
 *
 * @param <T>
 */
@SuppressWarnings("serial")
public class StreamKafkaLoaderImpl<T> extends KryoSerializer
		implements StreamingKafkaContext<T>, StreamingKakfaLoader<T> {
	protected static final Logger LOG = LoggerFactory.getLogger(StreamKafkaLoaderImpl.class);

	protected int reduceByKeyNum;
	protected Map<String, String> certProtocolMap;
	protected Map<String, String> macHasCompanyMap;
	protected String mysqlConn;
	protected String zkConn;
	protected String groupId;
	protected boolean enableIQ = false;
	protected String brokers;
	protected String streamingType;
	protected Map<String, String> params;
	protected JavaDStream<T> stream;

	public StreamKafkaLoaderImpl(SparkConf conf, Map<String, Broadcast<Map<String, String>>> broadcastRedisMap,
			Map<String, Broadcast<String>> broadcastMap, String streamingType) {
		super(conf);
		this.streamingType = streamingType;
		initFromBroadcast(broadcastRedisMap, broadcastMap);
	}

	/**
	 * 广播信息初始化
	 * 
	 * @param broadcastRedisMap
	 * @param broadcastMap
	 */
	private void initFromBroadcast(Map<String, Broadcast<Map<String, String>>> broadcastRedisMap,
			Map<String, Broadcast<String>> broadcastMap) {
	}

	@Override
	public StreamingKafkaContext<T> kafkaLoad(JavaStreamingContext jssc, Map<String, String> kafkaParams, String topic,
			Map<Integer, Long> partionAndOffset, MessageConverter<T> converter) {
		JavaDStream<String> kafkaStream = KafkaUtils.createDirectStream(jssc, String.class, String.class,
				StringDecoder.class, StringDecoder.class, String.class, kafkaParams,
				StreamHelper.topicOffsetToMap(zkConn, groupId, topic, partionAndOffset),
				new Function<MessageAndMetadata<String, String>, String>() {
					@Override
					public String call(MessageAndMetadata<String, String> msgAndMd) throws Exception {
						return msgAndMd.message();
					}
				});
		StreamHelper.updateOffsetToZk(kafkaStream, streamingType, zkConn, groupId);

		// flatMap
		this.stream = kafkaStream.flatMap(new FlatMapFunction<String, T>() {
			@Override
			public Iterable<T> call(String line) {
				String[] messages = line.split(SysContans.KAFKA_MESSAGES_SPLITER);
				int len = messages.length;
				List<T> lines = new ArrayList<T>(len);

				for (int i = 0; i < len; i++) {// 遍历所有的记录
					T message = converter.convert(messages[i]);

					// validate message
					if (converter.validate(message)) {
						lines.add(converter.update(message));
					}
				}
				return lines;
			}
		});

		return this;
	}

	@Override
	public JavaDStream<T> getStream() {
		return stream;
	}

	@Override
	public Map<String, String> getParams() {
		return params;
	}

	@Override
	public Map<String, String> getCertProtocolMap() {
		return certProtocolMap;
	}

	@Override
	public Map<String, String> getMacHasCompanyMap() {
		return macHasCompanyMap;
	}

}

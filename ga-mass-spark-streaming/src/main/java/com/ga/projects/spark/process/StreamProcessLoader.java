package com.ga.projects.spark.process;

import java.io.Serializable;
import java.util.Map;

import org.apache.spark.SparkConf;
import org.apache.spark.broadcast.Broadcast;
import org.apache.spark.serializer.KryoSerializer;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("serial")
public abstract class StreamProcessLoader<T extends Serializable> extends KryoSerializer
		implements StreamKafkaLoader<T> {
	protected static final Logger LOG = LoggerFactory.getLogger(StreamProcessLoader.class);

	protected static final int IQUERY_BATCH_SIZE = 10000;
	protected static final int IMPALA_BULK_SIZE = 10000;
	protected static final int BULK_SIZE = 10000;
	protected static final int RELATION_BULK_SIZE = 2000;

	protected int reduceByKeyNum;
	// 协议类型
	protected Map<String, String> certProtocolMap;
	// mac 厂商
	protected Map<String, String> macHasCompanyMap;
	protected String iDrillerConn;
	protected String mysqlConn;
	protected String redisInfo;
	protected String zkConn;
	protected String groupId;
	protected String hbaseParams;
	protected boolean enableIQ = false;
	protected String brokers;
	protected String allTracksTopic;
	protected int allTracksPushBatchSize;
	protected String relationTopic;
	protected String certTracksTopic;
	protected boolean versionIsGz;
	protected String streamingType;
	protected String friendTopic;
	protected boolean[] filterArr;
	protected Map<String, String> params;
	protected JavaDStream<T> stream;

	public StreamProcessLoader(SparkConf conf, Map<String, Broadcast<Map<String, String>>> broadcastRedisMap,
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
		this.iDrillerConn = broadcastMap.get("").getValue();

		params.put("iDrillerConn", iDrillerConn);
		params.put("mysqlConn", mysqlConn);
		params.put("redisInfo", redisInfo);
		params.put("zkConn", zkConn);
		params.put("groupId", groupId);
		params.put("allTracksTopic", allTracksTopic);
		params.put("allTracksPushBatchSize", String.valueOf(allTracksPushBatchSize));
		params.put("relationTopic", relationTopic);
		params.put("brokers", brokers);
		params.put("hbaseParams", hbaseParams);
		params.put("certTracksTopic", certTracksTopic);
		params.put("friendTopic", friendTopic);
		params.put("enableIQ", String.valueOf(enableIQ));
		params.put("versionIsGz", String.valueOf(versionIsGz));
	}

	/**
	 * 从Kafka加载数据创建流
	 * 
	 * @param jssc
	 * @param kafkaParams
	 * @param topic
	 * @param partionAndOffset
	 * @param filterArr
	 * @return
	 */
	@Override
	public abstract void kafkaLoad(JavaStreamingContext jssc, Map<String, String> kafkaParams, String topic,
			Map<Integer, Long> partionAndOffset);

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

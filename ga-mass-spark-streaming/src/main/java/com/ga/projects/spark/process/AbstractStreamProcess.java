package com.ga.projects.spark.process;

import java.io.Serializable;
import java.util.Map;

import org.apache.spark.streaming.api.java.JavaDStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 抽象的流式处理类
 * 
 * @author zealot
 */
@SuppressWarnings("serial")
public abstract class AbstractStreamProcess implements Serializable, Executor {

	protected static final Logger LOG = LoggerFactory.getLogger(AbstractStreamProcess.class);

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
	protected JavaDStream<String[]> stream;

	public AbstractStreamProcess(JavaDStream<String[]> stream, Map<String, String> certProtocolMap,
			Map<String, String> macHasCompanyMap, Map<String, String> params) {
		super();
		this.stream = stream;
		this.reduceByKeyNum = Integer.valueOf(params.get("reduceByKeyNum"));
		this.certProtocolMap = certProtocolMap;
		this.macHasCompanyMap = macHasCompanyMap;
		this.iDrillerConn = params.get("iDrillerConn");
		this.mysqlConn = params.get("mysqlConn");
		this.redisInfo = params.get("redisInfo");
		this.zkConn = params.get("zkConn");
		this.groupId = params.get("groupId");
		this.hbaseParams = params.get("hbaseParams");
		this.enableIQ = "true".equals(params.get("enableIQ"));
		this.brokers = params.get("brokers");
		this.allTracksTopic = params.get("allTracksTopic");
		this.allTracksPushBatchSize = Integer.valueOf(params.get("allTracksPushBatchSize"));
		this.relationTopic = params.get("relationTopic");
		this.certTracksTopic = params.get("certTracksTopic");
		this.versionIsGz = "true".equals(params.get("versionIsGz"));
		this.streamingType = params.get("streamingType");
		this.friendTopic = params.get("friendTopic");
	}

	@Override
	public abstract void start();
}

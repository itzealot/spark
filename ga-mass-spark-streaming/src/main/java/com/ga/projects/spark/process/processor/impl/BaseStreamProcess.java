package com.ga.projects.spark.process.processor.impl;

import org.apache.spark.streaming.api.java.JavaDStream;

import com.ga.projects.spark.process.StreamingKafkaContext;
import com.ga.projects.spark.process.api.OriginalLogger;
import com.ga.projects.spark.process.message.MessageParser;
import com.ga.projects.spark.process.processor.BaseProcessor;

import junit.framework.Assert;

/**
 * 
 * 
 * @author zealot
 *
 */
@SuppressWarnings("serial")
public class BaseStreamProcess implements BaseProcessor<String[]> {

	private OriginalLogger<String[]> originalLogger;

	public BaseStreamProcess() {
		super();
	}

	@Override
	public void start(StreamingKafkaContext<String[]> context, MessageParser parser) {
		Assert.assertNotNull("context can't be null", context);

		initParamsBy(context);

		JavaDStream<String[]> stream = context.getStream();

		if (stream != null && parser != null) {
			// 原始日志并入库
			if (originalLogger != null && originalLogger.isPersistOriginalLog()) {
				originalLogger.persistOriginalLog(stream);
			}

			// 分析关系数据并入库
			if (parser.isPersistRelation()) {
				persistRelation(stream, parser);
			}

			// 分析身份数据并入库
			if (parser.isPersistCertification()) {
				persistCertification(stream, parser);
			}

			// 分析身份数据轨迹数据并入库
			if (parser.isPersistCertificationTrack()) {
				persistCertificationTrack(stream, parser);
			}

			persistOthers(context, parser);
		}

	}

	/**
	 * persist others
	 * 
	 * @param context
	 * @param stream
	 * @param parser
	 */
	protected void persistOthers(StreamingKafkaContext<String[]> context, MessageParser parser) {
	}

	private void initParamsBy(StreamingKafkaContext<String[]> loader) {
	}

	protected final void persistRelation(JavaDStream<String[]> stream, MessageParser parser) {
	}

	protected final void persistCertification(JavaDStream<String[]> stream, MessageParser parser) {
	}

	protected final void persistCertificationTrack(JavaDStream<String[]> stream, MessageParser parser) {
	}

	@Override
	public BaseProcessor<String[]> register(OriginalLogger<String[]> originalLogger) {
		this.originalLogger = originalLogger;
		return this;
	}

}

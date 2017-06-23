package com.ga.projects.spark.process.processor.impl;

import org.apache.spark.streaming.api.java.JavaDStream;

import com.ga.projects.spark.process.StreamingKafkaContext;
import com.ga.projects.spark.process.message.MessageParser;

/**
 * FriendRelation 抽象的流式处理类
 * 
 * @author zealot
 */
@SuppressWarnings("serial")
public class FriendRelationStreamProcess extends BaseStreamProcess {

	public FriendRelationStreamProcess() {
		super();
	}

	@Override
	public final void start(StreamingKafkaContext<String[]> loader, MessageParser parser) {
		JavaDStream<String[]> stream = loader.getStream();

		if (stream != null) {
			persistFriendRelation(stream, parser);
		}
	}

	private void persistFriendRelation(JavaDStream<String[]> stream, MessageParser parser) {
	}

}

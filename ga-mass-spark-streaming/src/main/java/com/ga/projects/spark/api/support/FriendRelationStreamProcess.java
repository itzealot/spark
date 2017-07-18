package com.ga.projects.spark.api.support;

import com.ga.projects.spark.api.MessageParser;
import com.ga.projects.spark.api.StreamKafkaContext;

/**
 * FriendRelation 抽象的流式处理类
 * 
 * @author zealot
 */
@SuppressWarnings("serial")
public class FriendRelationStreamProcess extends AbstractStreamProcess {

	public FriendRelationStreamProcess(StreamKafkaContext<String[]> context) {
		super(context);
	}

	@Override
	protected void persist(MessageParser parser) {
		persistFriendRelation(parser);
	}

	private void persistFriendRelation(MessageParser parser) {
		// TODO
	}

}

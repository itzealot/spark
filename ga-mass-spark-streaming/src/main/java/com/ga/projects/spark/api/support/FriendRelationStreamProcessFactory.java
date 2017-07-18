package com.ga.projects.spark.api.support;

import com.ga.projects.spark.api.Processor;
import com.ga.projects.spark.api.ProcessorFactory;
import com.ga.projects.spark.api.StreamKafkaContext;

public class FriendRelationStreamProcessFactory implements ProcessorFactory<String[]> {

	@Override
	public Processor<String[]> getProcessor(StreamKafkaContext<String[]> context) {
		return new FriendRelationStreamProcess(context);
	}

}

package com.ga.projects.spark.main;

import org.apache.spark.serializer.KryoRegistrator;

import com.esotericsoftware.kryo.Kryo;
import com.ga.projects.spark.streaming.StreamProcessDemo;

/**
 * 流式处理的注册类
 * 
 * @author zealot
 */
public class StreamRegistrator implements KryoRegistrator {

	@Override
	public void registerClasses(Kryo kryo) {
		kryo.register(StreamProcessDemo.class);
	}

}

package com.ga.projects.spark.process;

@SuppressWarnings("serial")
public class StreamProcess implements Executor {

	private Executor executor;

	public StreamProcess(StreamKafkaLoader<String[]> loader) {
		super();
	}

	@Override
	public void start() {
		this.executor.start();
	}

}

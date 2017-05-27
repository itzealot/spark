package com.ga.projects.spark.process;

import java.io.Serializable;

public interface Executor extends Serializable {

	/**
	 * 启动程序进行消费
	 */
	void start();
}

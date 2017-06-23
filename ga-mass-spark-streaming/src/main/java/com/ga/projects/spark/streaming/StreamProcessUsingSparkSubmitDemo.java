package com.ga.projects.spark.streaming;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;

/**
 * 使用 spark-submit 提交Spark任务
 * 
 * @author zealot
 *
 */
public class StreamProcessUsingSparkSubmitDemo {

	public static void main(String[] args) {
		SparkConf conf = new SparkConf();

		// 注册
		conf.registerKryoClasses(new Class[] {});

		// 设置相关信息
		if (conf.getBoolean("spark.istest", true)) {
			conf.setAppName("AppName");
			conf.setMaster("local");
		}

		JavaSparkContext sc = new JavaSparkContext(conf);
	}

}

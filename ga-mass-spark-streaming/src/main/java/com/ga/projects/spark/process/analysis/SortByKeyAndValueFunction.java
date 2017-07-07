package com.ga.projects.spark.process.analysis;

import org.apache.spark.api.java.JavaRDD;

/**
 * SortByKeyAndValueFunction
 * 
 * @author zealot
 *
 * @param <T>
 */
public interface SortByKeyAndValueFunction<T> extends SortFunction<T> {

	/**
	 * sortByKeyAndValue
	 * 
	 * @param rdd
	 */
	void sortByKeyAndValue(JavaRDD<T> rdd);

}

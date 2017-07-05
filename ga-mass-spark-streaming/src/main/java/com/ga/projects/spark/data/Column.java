package com.ga.projects.spark.data;

/**
 * 
 * @author zealot
 *
 */
public interface Column {

	String getColumnName();

	Class<?> getColumnType();

	int getColumnLength();
}

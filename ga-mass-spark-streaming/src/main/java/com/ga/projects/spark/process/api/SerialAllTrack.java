package com.ga.projects.spark.process.api;

public interface SerialAllTrack extends AllTrack {

	/**
	 * all_track是否进行合并
	 * 
	 * @return
	 */
	@Override
	default boolean isMergeAllTrack() {
		return true;
	}
}

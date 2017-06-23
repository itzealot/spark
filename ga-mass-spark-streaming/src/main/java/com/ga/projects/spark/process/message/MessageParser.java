package com.ga.projects.spark.process.message;

import java.util.List;

import com.ga.projects.spark.process.entity.Id;

/**
 * Message Parser
 * 
 * @author zealot
 *
 */
public interface MessageParser {

	/**
	 * do map convert, if it doesn't convert then return origin array
	 * 
	 * @param arrays
	 * @return
	 */
	String[] map(String[] arrays);

	/**
	 * [0]:id, [1]:idType
	 * 
	 * @param arrays
	 * @return
	 */
	List<Id> getIds(String[] arrays);

	/**
	 * [0]:provinceCode, [1]:cityCode, [2]:areaCode
	 * 
	 * @param arrays
	 * @return
	 */
	String[] getCodes(String[] arrays);

	/**
	 * serviceCode
	 * 
	 * @param arrays
	 * @return
	 */
	String getServiceCode(String[] arrays);

	/**
	 * [0]:sysSource, [1]:source, [2]:companyId
	 * 
	 * @param arrays
	 * @return
	 */
	String[] getSources(String[] arrays);

	/**
	 * [0]:startTime, [1]:endTime, [2]:createTime, [3]:partitionTime
	 * 
	 * @param arrays
	 * @return
	 */
	String[] getTimes(String[] arrays);

	boolean isPersistCertification();

	boolean isPersistCertificationTrack();

	boolean isPersistRelation();

	/**
	 * 是否持久化AllTrack
	 * 
	 * @return
	 */
	default boolean isPersistAllTrack() {
		return true;
	}

	/**
	 * all_track是否进行合并
	 * 
	 * @return
	 */
	default boolean isMergeAllTrack() {
		return false;
	}
}

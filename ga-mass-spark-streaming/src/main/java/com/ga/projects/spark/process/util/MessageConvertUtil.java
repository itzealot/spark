package com.ga.projects.spark.process.util;

import java.util.ArrayList;
import java.util.List;

import com.ga.projects.spark.process.entity.Id;
import com.ga.projects.spark.process.message.MessageParser;

/**
 * Message Convert Util
 * 
 * @author zealot
 *
 */
public final class MessageConvertUtil {

	/**
	 * id, idType, firstStartTime, firstServiceCode, source, sysSource,
	 * companyId, createTime, createTimeP, times, lastStartTime, lastServiceCode
	 * 
	 * @param arrays
	 * @param parser
	 * @return
	 */
	public static Iterable<String[]> buildCertificationBy(String[] arrays, MessageParser parser) {
		List<Id> ids = parser.getIds(arrays);
		List<String[]> lists = new ArrayList<>(ids.size());

		String[] times = parser.getTimes(arrays);
		String[] sources = parser.getSources(arrays);
		String serviceCode = parser.getServiceCode(arrays);

		// build certification
		for (Id id : ids) {
			lists.add(new String[] { id.getId(), id.getIdType(), times[0], serviceCode, sources[1], sources[0],
					sources[2], times[2], times[3], times[3], "1", times[0], serviceCode });
		}

		return lists;
	}

	public static Iterable<String[]> buildCertificationTrackBy(String[] arrays, MessageParser parser) {
		return null;
	}

	public static Iterable<String[]> buildRelationBy(String[] arrays, MessageParser parser) {
		return null;
	}

	private MessageConvertUtil() {
	}
}

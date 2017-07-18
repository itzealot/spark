package com.ga.projects.spark.api.support;

import com.ga.projects.spark.api.MessageParser;
import com.ga.projects.spark.api.Persistent;
import com.ga.projects.spark.api.StreamKafkaContext;

@SuppressWarnings("serial")
public abstract class AllTrackStreamProcess extends AbstractStreamProcess {

	public AllTrackStreamProcess(StreamKafkaContext<String[]> context) {
		super(context);
	}

	@Override
	protected void persist(MessageParser parser) {
		doPersist(parser);

		// 分析 AllTracks 并入库
		Persistent persistent = parser.getPersistent();

		if (persistent != null && persistent.isPersistAllTrack()) {
			if (!persistent.isMergeAllTrack()) {
				persistAllTrack(parser);
			} else {
				persistAllTrackWithMerge(parser);
			}
		}
	}

	protected final void persistAllTrack(MessageParser parser) {
		// TODO
	}

	protected final void persistAllTrackWithMerge(MessageParser parser) {
		// TODO
	}

	/**
	 * 持久化
	 * 
	 * @param parser
	 */
	protected abstract void doPersist(MessageParser parser);
}

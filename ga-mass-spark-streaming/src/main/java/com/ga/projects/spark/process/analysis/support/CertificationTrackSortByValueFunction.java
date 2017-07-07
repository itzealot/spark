package com.ga.projects.spark.process.analysis.support;

import com.ga.projects.spark.process.entity.CertificationTrack;

@SuppressWarnings("serial")
public class CertificationTrackSortByValueFunction extends AbstractSortByValueFunction<CertificationTrack> {

	@Override
	public CertificationTrack reduce(CertificationTrack c1, CertificationTrack c2) {
		return null;
	}

	@Override
	public String getReduceKey(CertificationTrack track) {
		return null;
	}

}

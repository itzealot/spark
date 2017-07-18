package com.ga.projects.spark.api.persistence;

import com.ga.projects.spark.api.Persistent;

/**
 * BasePersistence
 * 
 * @author zealot
 */
public class BasePersistence implements Persistent {

	@Override
	public boolean isPersistCertification() {
		return true;
	}

	@Override
	public boolean isPersistCertificationTrack() {
		return true;
	}

	@Override
	public boolean isPersistRelation() {
		return true;
	}

	@Override
	public boolean isPersistAllTrack() {
		return false;
	}

	@Override
	public boolean isMergeAllTrack() {
		return false;
	}

}

package com.ga.projects.spark.process.entity;

import java.io.Serializable;

/**
 * Id(id, idType)
 * 
 * @author zealot
 *
 */
public class Id implements Serializable {
	private static final long serialVersionUID = -3131315574866698102L;

	private String id;
	private String idType;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}
}
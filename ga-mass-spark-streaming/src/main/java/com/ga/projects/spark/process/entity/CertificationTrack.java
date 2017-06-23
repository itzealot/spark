package com.ga.projects.spark.process.entity;

import java.io.Serializable;

/**
 * 身份的轨迹合并实体表
 * 
 * @author zealot
 *
 */
public class CertificationTrack implements Serializable {

	private static final long serialVersionUID = -261515867043597801L;
	private String id; // 身份
	private String idType; // 身份所属协议
	private String serviceCode; // 场所
	private Long startTime; // 首次出现时间
	private Long endTime; // 最后一次出现时间
	private Integer lingerTime; // 逗留时长
	private Integer maxLingerTime; // 最大逗留时长
	private Integer times; // 累计出现次数
	private Short source; // 最近出现的来源
	private Short sysSource; // 最近出现的大类
	private String companyId; // 最近出现的厂商来源

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

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	public Long getStartTime() {
		return startTime;
	}

	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}

	public Long getEndTime() {
		return endTime;
	}

	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}

	public Integer getLingerTime() {
		return lingerTime;
	}

	public void setLingerTime(Integer lingerTime) {
		this.lingerTime = lingerTime;
	}

	public Integer getMaxLingerTime() {
		return maxLingerTime;
	}

	public void setMaxLingerTime(Integer maxLingerTime) {
		this.maxLingerTime = maxLingerTime;
	}

	public Integer getTimes() {
		return times;
	}

	public void setTimes(Integer times) {
		this.times = times;
	}

	public Short getSource() {
		return source;
	}

	public void setSource(Short source) {
		this.source = source;
	}

	public Short getSysSource() {
		return sysSource;
	}

	public void setSysSource(Short sysSource) {
		this.sysSource = sysSource;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

}

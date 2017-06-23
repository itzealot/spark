package com.ga.projects.spark.process.entity;

import java.io.Serializable;
import java.util.List;

public class Certification implements Serializable {

	private static final long serialVersionUID = -1480769938600629598L;

	private List<Id> ids;

	private String certType;
	private String deviceNum;
	private String provinceCode;
	private String cityCode;
	private String areaCode;
	private String serviceCode;
	private String startTime;
	private String times;
	private String source;
	private String sysSource;
	private String companyId;
	private String centerCode;
	private String createTime;
	private String createTimeP;

	public Certification(List<Id> ids, String certType, String deviceNum, String provinceCode, String cityCode,
			String areaCode, String serviceCode, String startTime, String times, String source, String sysSource,
			String companyId, String centerCode, String createTime, String createTimeP) {
		super();
		this.ids = ids;
		this.certType = certType;
		this.deviceNum = deviceNum;
		this.provinceCode = provinceCode;
		this.cityCode = cityCode;
		this.areaCode = areaCode;
		this.serviceCode = serviceCode;
		this.startTime = startTime;
		this.times = times;
		this.source = source;
		this.sysSource = sysSource;
		this.companyId = companyId;
		this.centerCode = centerCode;
		this.createTime = createTime;
		this.createTimeP = createTimeP;
	}

	public List<Id> getIds() {
		return ids;
	}

	public void setIds(List<Id> ids) {
		this.ids = ids;
	}

	public String getCertType() {
		return certType;
	}

	public void setCertType(String certType) {
		this.certType = certType;
	}

	public String getDeviceNum() {
		return deviceNum;
	}

	public void setDeviceNum(String deviceNum) {
		this.deviceNum = deviceNum;
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getTimes() {
		return times;
	}

	public void setTimes(String times) {
		this.times = times;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSysSource() {
		return sysSource;
	}

	public void setSysSource(String sysSource) {
		this.sysSource = sysSource;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getCenterCode() {
		return centerCode;
	}

	public void setCenterCode(String centerCode) {
		this.centerCode = centerCode;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getCreateTimeP() {
		return createTimeP;
	}

	public void setCreateTimeP(String createTimeP) {
		this.createTimeP = createTimeP;
	}

}

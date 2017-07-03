package com.ga.projects.spark.process.entity;

/**
 * 按天合并的身份的轨迹信息，即一个身份在一天内对场所信息的合并
 * 
 * select id, idType, serviceCode, min(provinceCode), min(cityCode),
 * min(areaCode), min(startTime) as minStartTime, max(endTime) as maxEndTime,
 * sum(lingerTime) as sumLingerTime from TimeSliceCertificationTrack group by
 * id, idType, serviceCode [where ...]
 * 
 * @author zealot
 *
 */
public class DayCertificationTrack {
	/**
	 * 身份证号，没有则为 null，用于后续人的关联
	 */
	private String certCode;

	/**
	 * 手机号，没有则为 null，用于后续人的关联
	 */
	private String phone;

	/**
	 * IMEI，没有则为 null，用于后续人的关联
	 */
	private String imei;

	/**
	 * IMSI，没有则为 null，用于后续人的关联
	 */
	private String imsi;

	/**
	 * 身份，如 MAC 地址
	 */
	private String id;

	/**
	 * 身份所属协议，如 MAC 对应的协议编号为 1020002
	 */
	private String idType;

	/**
	 * 身份出现的场所编码、省编码、市编码、县编码
	 */
	private String provinceCode; // 省编码
	private String cityCode; // 市编码
	private String areaCode; // 区域编码
	private String serviceCode; // 场所编码

	/**
	 * 在场所内的首次出现时间，一天之中首次出现的时间
	 */
	private long startTime;

	/**
	 * 在场所内的最后一次出现时间，一天之中最后一次出现的时间
	 */
	private long endTime;

	/**
	 * 在场所内一天的总逗留时长
	 */
	private int lingerTime;

	/**
	 * 在场所内的最大逗留时长
	 */
	private int maxLingerTime;

	/**
	 * 在场所内的最小逗留时长
	 */
	private int minLingerTime;

	/**
	 * 当天在某场所的累计出现次数
	 */
	private int times;

	/**
	 * 最近出现的大类
	 */
	private short sysSource;

	/**
	 * 最近出现的来源
	 */
	private short source;

	/**
	 * 最近出现的厂商
	 */
	private String companyId;

	/**
	 * 创建时间，绝对秒数
	 */
	private long createTime;

	/**
	 * 按天分区时间，分区like: 20170703
	 */
	private String startTimeP;

	public String getCertCode() {
		return certCode;
	}

	public void setCertCode(String certCode) {
		this.certCode = certCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getImsi() {
		return imsi;
	}

	public void setImsi(String imsi) {
		this.imsi = imsi;
	}

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

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public long getEndTime() {
		return endTime;
	}

	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}

	public int getLingerTime() {
		return lingerTime;
	}

	public void setLingerTime(int lingerTime) {
		this.lingerTime = lingerTime;
	}

	public int getMaxLingerTime() {
		return maxLingerTime;
	}

	public void setMaxLingerTime(int maxLingerTime) {
		this.maxLingerTime = maxLingerTime;
	}

	public int getMinLingerTime() {
		return minLingerTime;
	}

	public void setMinLingerTime(int minLingerTime) {
		this.minLingerTime = minLingerTime;
	}

	public int getTimes() {
		return times;
	}

	public void setTimes(int times) {
		this.times = times;
	}

	public short getSysSource() {
		return sysSource;
	}

	public void setSysSource(short sysSource) {
		this.sysSource = sysSource;
	}

	public short getSource() {
		return source;
	}

	public void setSource(short source) {
		this.source = source;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	public String getStartTimeP() {
		return startTimeP;
	}

	public void setStartTimeP(String startTimeP) {
		this.startTimeP = startTimeP;
	}

}

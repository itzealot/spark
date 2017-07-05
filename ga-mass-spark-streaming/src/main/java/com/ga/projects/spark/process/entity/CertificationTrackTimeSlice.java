package com.ga.projects.spark.process.entity;

/**
 * 按区间段合并的身份轨迹(按 id+idType+serviceCode+startTimeP 排重后合并的时间范围区段).<br>
 * 1.采用离线计算的方式计算步骤：<br>
 * 1).从 CertificationTrackAllTime 表按startTime递增, endTime递增的顺序查询出所有的轨迹进行分析.<br>
 * 2).合并所有的数据，在时间范围内(时间间隔在指定范围内认为是在该场所内逗留)则轨迹进行合并；否则认为是新的记录.<br>
 * 
 * 2.按天合并的身份的轨迹信息，即一个身份在一天内对场所信息的合并，直接可以使用sql表示:<br>
 * select id, idType, serviceCode, min(provinceCode) as provinceCode,
 * min(cityCode) as cityCode, min(areaCode) as areaCode, min(policeCode) as
 * policeCode, min(startTime) as minStartTime, max(endTime) as maxEndTime,
 * sum(lingerTime) as sumLingerTime, min(lingerTime) as minLingerTime,
 * max(lingerTime) as maxLingerTime, sum(times) as sumTimes, sum(lingerTimes) as
 * sumLingerTimes from CertificationTrackTimeSlice [where startTimeP='' and ...]
 * group by id, idType, serviceCode;
 * 
 * 3.若是按月，则直接进行按月统计即可，前提是支持这么大量数据的统计分析，当然也可以基于当前表抽取出对应的日表统计、周表统计
 * 
 * @author zealot
 *
 */
public class CertificationTrackTimeSlice {

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
	 * 身份出现的场所编码、省编码、市编码、县编码、派出所编码、场所编码
	 */
	private String provinceCode; // 省编码
	private String cityCode; // 市编码
	private String areaCode; // 区域编码
	private String policeCoe; // 派出所编码
	private String serviceCode; // 场所编码

	/**
	 * 在场所中一段时间内的首次出现时间
	 */
	private long startTime;

	/**
	 * 在场所中一段时间内的最后一次出现时间
	 */
	private long endTime;

	/**
	 * 逗留时长，为 endTime-startTime 的绝对秒数
	 */
	private int lingerTime;

	/**
	 * 当天在某场所的累计出现次数，一条记录则记为出现一次
	 */
	private int times;

	/**
	 * 逗留次数，即在数据合并时数据合并的次数
	 */
	private int lingerTimes;

	/**
	 * 最近出现的系统来源
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

	public String getPoliceCoe() {
		return policeCoe;
	}

	public void setPoliceCoe(String policeCoe) {
		this.policeCoe = policeCoe;
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

	public int getTimes() {
		return times;
	}

	public void setTimes(int times) {
		this.times = times;
	}

	public int getLingerTimes() {
		return lingerTimes;
	}

	public void setLingerTimes(int lingerTimes) {
		this.lingerTimes = lingerTimes;
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

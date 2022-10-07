package com.excelpojo;

import com.poiji.annotation.ExcelCellName;

/**
 * @author Keshav_Koli
 */
public class ExcelCellModel {

	@ExcelCellName("EMPCODE")
	private String empCode;

	@ExcelCellName("LOGINID")
	private String loginId;

	@ExcelCellName("LOGINNAME")
	private String loginName;

	@ExcelCellName("Email_ID")
	private String emailId;

	@ExcelCellName("USERCODE")
	private String userCode;

	@ExcelCellName("ZONE")
	private String zone;

	@ExcelCellName("CLUSTER")
	private String cluster;

	@ExcelCellName("BRANCHCODE")
	private String branchCode;

	public ExcelCellModel() {
	}

	public ExcelCellModel(String empCode, String loginId, String loginName, String emailId, String userCode,
			String zone, String cluster, String branchCode) {
		super();
		this.empCode = empCode;
		this.loginId = loginId;
		this.loginName = loginName;
		this.emailId = emailId;
		this.userCode = userCode;
		this.zone = zone;
		this.cluster = cluster;
		this.branchCode = branchCode;
	}

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getCluster() {
		return cluster;
	}

	public void setCluster(String cluster) {
		this.cluster = cluster;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

}

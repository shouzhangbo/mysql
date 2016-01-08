package com.my.mysql.response.bean;

import java.util.Date;

import javax.persistence.Column;

public class MgUserBeans {
	private Integer mgUserId;
	private String mgUserName;
	private String mgPsd;
	private Integer status;
	private String statusName;
	private Date createAt;
	private Date updateAt;
	private String RoleName;
	public Integer getMgUserId() {
		return mgUserId;
	}
	public void setMgUserId(Integer mgUserId) {
		this.mgUserId = mgUserId;
	}
	public String getMgUserName() {
		return mgUserName;
	}
	public void setMgUserName(String mgUserName) {
		this.mgUserName = mgUserName;
	}
	public String getMgPsd() {
		return mgPsd;
	}
	public void setMgPsd(String mgPsd) {
		this.mgPsd = mgPsd;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public Date getUpdateAt() {
		return updateAt;
	}
	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}
	public String getRoleName() {
		return RoleName;
	}
	public void setRoleName(String roleName) {
		RoleName = roleName;
	}
}

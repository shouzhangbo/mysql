package com.my.mysql.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity   
@Table(name="mg_user")
public class MgUser {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "mg_user_id",length=11)
	private Integer mgUserId;
	@Column(name = "mg_user_name",length=32)
	private String mgUserName;
	@Column(name = "mg_psd",length=64)
	private String mgPsd;
	@Column(name = "status",length=2)
	private Integer status;
	@Column(name = "status_name",length=32)
	private String statusName;
	@Column(name = "create_at", nullable = false)
	private Date createAt;
	@Column(name = "update_at", nullable = false)
	private Date updateAt;
	
	@ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.MERGE }, optional = true)
	@JoinColumn(name = "role_id")
	
	private Role role;
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
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
}

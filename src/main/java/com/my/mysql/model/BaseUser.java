package com.my.mysql.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity   
@Table(name="base_user")
public class BaseUser {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "base_user_id")
	private Integer baseUserId;
	@Column(name = "user_name",length=64, nullable = false)
	private String userName;
	@Column(name = "base_psd",length=128, nullable = false)
	private String basePsd;
	@Column(name = "Create_at", nullable = false)
	private Date CreateAt;
	@Column(name = "Update_at", nullable = false)
	private Date UpdateAt;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "baseInfo")
	private Set<UserInfo> userInfo;
	public Integer getBaseUserId() {
		return baseUserId;
	}
	public void setBaseUserId(Integer baseUserId) {
		this.baseUserId = baseUserId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getBasePsd() {
		return basePsd;
	}
	public void setBasePsd(String basePsd) {
		this.basePsd = basePsd;
	}
	public Date getCreateAt() {
		return CreateAt;
	}
	public void setCreateAt(Date createAt) {
		CreateAt = createAt;
	}
	public Date getUpdateAt() {
		return UpdateAt;
	}
	public void setUpdateAt(Date updateAt) {
		UpdateAt = updateAt;
	}
	public Set<UserInfo> getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(Set<UserInfo> userInfo) {
		this.userInfo = userInfo;
	}
}

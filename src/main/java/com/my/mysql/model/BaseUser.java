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

import org.hibernate.annotations.Cascade;

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
	@Column(name = "status",length=2)
	private Integer status;
	@Column(name = "status_name",length=10)
	private String statusName;
	@Column(name = "Create_at", nullable = false)
	private Date CreateAt;
	@Column(name = "Update_at", nullable = false)
	private Date UpdateAt;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "baseInfo")
	@Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE,org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
	private Set<UserInfo> userInfo;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "addresUser")
	@Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE,org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
	private Set<Address> address;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "baseEval")
	@Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE,org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
	private Set<Evaluation> evaluation;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "baseUser")
	@Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE,org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
	private Set<Order> orderInfo;
	
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
	public Set<Address> getAddress() {
		return address;
	}
	public void setAddress(Set<Address> address) {
		this.address = address;
	}
	public Set<Evaluation> getEvaluation() {
		return evaluation;
	}
	public void setEvaluation(Set<Evaluation> evaluation) {
		this.evaluation = evaluation;
	}
	public Set<Order> getOrderInfo() {
		return orderInfo;
	}
	public void setOrderInfo(Set<Order> orderInfo) {
		this.orderInfo = orderInfo;
	}
}

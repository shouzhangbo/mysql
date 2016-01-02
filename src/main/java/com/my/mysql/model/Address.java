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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity   
@Table(name="address")
public class Address {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id",length=11)
	private Integer addressId;
	@Column(name = "address_street",length=100)
	private String addressStreet;
	@Column(name = "address_info",length=100)
	private String addressInfo;
	@Column(name = "receive_phone",length=11)
	private String receivePhone;
	@Column(name = "receive_man",length=11)
	private String receiveMan;
	@Column(name = "Create_at", nullable = false)
	private Date CreateAt;
	@Column(name = "Update_at", nullable = false)
	private Date UpdateAt;
	
	@ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.MERGE }, optional = true)
	@JoinColumn(name = "base_user_id")
	private BaseUser addresUser;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "address")
	@Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE,org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
	private Set<Order> orderInfo;
	
	public Set<Order> getOrderInfo() {
		return orderInfo;
	}
	public void setOrderInfo(Set<Order> orderInfo) {
		this.orderInfo = orderInfo;
	}
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public String getAddressStreet() {
		return addressStreet;
	}
	public void setAddressStreet(String addressStreet) {
		this.addressStreet = addressStreet;
	}
	public String getAddressInfo() {
		return addressInfo;
	}
	public void setAddressInfo(String addressInfo) {
		this.addressInfo = addressInfo;
	}
	public String getReceivePhone() {
		return receivePhone;
	}
	public void setReceivePhone(String receivePhone) {
		this.receivePhone = receivePhone;
	}
	public String getReceiveMan() {
		return receiveMan;
	}
	public void setReceiveMan(String receiveMan) {
		this.receiveMan = receiveMan;
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
	public BaseUser getAddresUser() {
		return addresUser;
	}
	public void setAddresUser(BaseUser addresUser) {
		this.addresUser = addresUser;
	}
}

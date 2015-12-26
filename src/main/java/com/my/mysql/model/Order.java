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
@Table(name="orders")
public class Order {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id",length=11)
	private Integer orderId;
	@Column(name = "status",length=2)
	private Integer status;
	@Column(name = "status_name",length=32)
	private String statusName;
	@Column(name = "order_price",length=11)
	private Integer orderPrice;
	@Column(name = "order_no",length=32)
	private String orderNo;
	@Column(name = "Create_at", nullable = false)
	private Date CreateAt;
	@Column(name = "Update_at", nullable = false)
	private Date UpdateAt;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "order")
	@Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE,org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
	private Set<OrderInfo> orderInfo;
	
	
	@ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.MERGE }, optional = true)
	@JoinColumn(name = "base_user_id")
	private BaseUser baseUser;
	
	@ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.MERGE }, optional = true)
	@JoinColumn(name = "addres_id")
	private Address address;
	
	
	@ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.MERGE }, optional = true)
	@JoinColumn(name = "eval_id")
	private Evaluation evaluation;
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
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
	public Integer getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(Integer orderPrice) {
		this.orderPrice = orderPrice;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public Set<OrderInfo> getOrderInfo() {
		return orderInfo;
	}
	public void setOrderInfo(Set<OrderInfo> orderInfo) {
		this.orderInfo = orderInfo;
	}
	public BaseUser getBaseUser() {
		return baseUser;
	}
	public void setBaseUser(BaseUser baseUser) {
		this.baseUser = baseUser;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Evaluation getEvaluation() {
		return evaluation;
	}
	public void setEvaluation(Evaluation evaluation) {
		this.evaluation = evaluation;
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
}

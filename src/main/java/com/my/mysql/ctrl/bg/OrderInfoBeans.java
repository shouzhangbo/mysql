package com.my.mysql.ctrl.bg;

import java.util.Date;


public class OrderInfoBeans {
	
	private Integer orderInfoId;
	private Integer count;
	private Integer orderInfoPrice;
	private String orderInfoNo;
	private Integer status;
	private String statusName;
	private Date CreateAt;
	private Date UpdateAt;
	
	public Integer getOrderInfoId() {
		return orderInfoId;
	}
	public void setOrderInfoId(Integer orderInfoId) {
		this.orderInfoId = orderInfoId;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getOrderInfoPrice() {
		return orderInfoPrice;
	}
	public void setOrderInfoPrice(Integer orderInfoPrice) {
		this.orderInfoPrice = orderInfoPrice;
	}
	public String getOrderInfoNo() {
		return orderInfoNo;
	}
	public void setOrderInfoNo(String orderInfoNo) {
		this.orderInfoNo = orderInfoNo;
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

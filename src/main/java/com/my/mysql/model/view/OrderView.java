package com.my.mysql.model.view;

import java.util.Date;

public class OrderView {

	public OrderView(){}
	public OrderView(Integer orderId,Integer status,String statusName,Integer orderPrice,String orderNo,
			Date createAt,Date updateAt,Integer baseUserId,Integer addressId,Integer evaluationId)
	{
		this.orderId = orderId;
		this.status = status;
		this.statusName = statusName;
		this.orderPrice = orderPrice;
		this.orderNo = orderNo;
		this.createAt = createAt;
		this.updateAt = updateAt;
	 	this.baseUserId = baseUserId;
		this.addressId= addressId;
		this.evaluationId = evaluationId;
	}
	private Integer orderId;
	private Integer status;
	private String statusName;
	private Integer orderPrice;
	private String orderNo;
	private Date createAt;
	private Date updateAt;
 	private Integer baseUserId;
	private Integer addressId;
	private Integer evaluationId;
	
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
	public Integer getBaseUserId() {
		return baseUserId;
	}
	public void setBaseUserId(Integer baseUserId) {
		this.baseUserId = baseUserId;
	}
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public Integer getEvaluationId() {
		return evaluationId;
	}
	public void setEvaluationId(Integer evaluationId) {
		this.evaluationId = evaluationId;
	}
}

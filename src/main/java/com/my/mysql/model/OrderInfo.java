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
@Table(name="order_info")
public class OrderInfo {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_info_id",length=11)
	private Integer orderInfoId;
	@Column(name = "count",length=11)
	private Integer count;
	@Column(name = "order_info_price",length=11)
	private Integer orderInfoPrice;
	@Column(name = "order_info_no",length=32)
	private String orderInfoNo;
	@Column(name = "status",length=11)
	private Integer status;
	@Column(name = "status_name",length=32)
	private String statusName;
	@Column(name = "Create_at", nullable = false)
	private Date CreateAt;
	@Column(name = "Update_at", nullable = false)
	private Date UpdateAt;
	
	@ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.MERGE }, optional = true)
	@JoinColumn(name = "product_id")
	private Product product;
	
	@ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.MERGE }, optional = true)
	@JoinColumn(name = "order_id")
	private Order order;

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

	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	
	
}

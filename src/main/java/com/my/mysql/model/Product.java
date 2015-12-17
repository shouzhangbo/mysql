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

@Entity   
@Table(name="product")
public class Product {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id",length=11)
	private Integer productId;
	@Column(name = "product_name",length=64)
	private String productName;
	@Column(name = "product_desc",length=512)
	private String productDesc;
	@Column(name = "product_status",length=2)
	private Integer productStatus;
	@Column(name = "product_status_name",length=10)
	private String productStatusName;
	@Column(name = "create_at")
	private Date createAt;
	@Column(name = "update_at")
	private Date updateAt;
	@Column(name = "product_img_first",length=32)
	private String productImgFirst;
	@Column(name = "product_img",length=512)
	private String productImg;
	//价格
	@Column(name = "price")
	private Integer price;
	//库存
	@Column(name = "stock")
	private Integer stock;
	//销量
	@Column(name = "sale_num")
	private Integer saleNum;
	//现在剩余
	@Column(name = "now_num")
	private Integer nowNum;
	
	@ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.MERGE }, optional = true)
	@JoinColumn(name = "brand_id")
	private Brand brand;
	
	@ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.MERGE }, optional = true)
	@JoinColumn(name = "cate_thr_id")
	private CategoryThr categoryThr;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
	private Set<OrderInfo> orderInfo;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public Integer getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(Integer productStatus) {
		this.productStatus = productStatus;
	}

	public String getProductStatusName() {
		return productStatusName;
	}

	public void setProductStatusName(String productStatusName) {
		this.productStatusName = productStatusName;
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

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public CategoryThr getCategoryThr() {
		return categoryThr;
	}

	public void setCategoryThr(CategoryThr categoryThr) {
		this.categoryThr = categoryThr;
	}

	public String getProductImgFirst() {
		return productImgFirst;
	}

	public void setProductImgFirst(String productImgFirst) {
		this.productImgFirst = productImgFirst;
	}

	public String getProductImg() {
		return productImg;
	}

	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Integer getSaleNum() {
		return saleNum;
	}

	public void setSaleNum(Integer saleNum) {
		this.saleNum = saleNum;
	}

	public Integer getNowNum() {
		return nowNum;
	}

	public void setNowNum(Integer nowNum) {
		this.nowNum = nowNum;
	}

	public Set<OrderInfo> getOrderInfo() {
		return orderInfo;
	}

	public void setOrderInfo(Set<OrderInfo> orderInfo) {
		this.orderInfo = orderInfo;
	}
	
}

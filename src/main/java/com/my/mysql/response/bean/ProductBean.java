package com.my.mysql.response.bean;

import com.my.mysql.model.Product;

public class ProductBean {

	public ProductBean(){}
	public ProductBean(Product pro){
		this.productId = pro.getProductId();
		this.productName = pro.getProductName();
		this.productDesc =  pro.getProductDesc();
		this.productStatus = pro.getProductStatus();
		this.productStatusName = pro.getProductStatusName();
		this.productImgFirst =  pro.getProductImgFirst();
		this.productImg = pro.getProductImg();
		
		this.price = pro.getPrice();
		this.stock = pro.getStock();
		this.saleNum = pro.getSaleNum();
		this.nowNum = pro.getNowNum();
	}
	private Integer productId;
	private String productName;
	private String productDesc;
	private Integer productStatus;
	private String productStatusName;
	private String productImgFirst;
	private String productImg;
	
	private Integer price;
	private Integer stock;
	private Integer saleNum;
	private Integer nowNum;
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
	public String getProductStatusName() {
		return productStatusName;
	}
	public void setProductStatusName(String productStatusName) {
		this.productStatusName = productStatusName;
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
	public Integer getProductStatus() {
		return productStatus;
	}
	public void setProductStatus(Integer productStatus) {
		this.productStatus = productStatus;
	}
}

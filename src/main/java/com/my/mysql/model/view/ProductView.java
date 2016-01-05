package com.my.mysql.model.view;

import java.util.Date;

public class ProductView {
	
	
	public ProductView(){}
	public ProductView(Integer productId,String productName,String productDesc,Integer productStatus,
			String productStatusName,Date createAt,Date updateAt,String productImgFirst,String productImg,
			Integer price,Integer stock,Integer saleNum,Integer nowNum,Integer brandId,Integer cateThrId)
	{
		this.productId = productId;
		this.productName =productName;
		this.productDesc = productDesc;
		this.productStatus = productStatus;
		this.productStatusName = productStatusName;
		this.createAt = createAt;
		this.updateAt = updateAt;
		this.productImgFirst = productImgFirst;
		this.productImg = productImg;
		this.price = price;
		this.stock = stock;
		this.saleNum = saleNum;
		this.nowNum = nowNum;
		this.brandId = brandId;
		this.cateThrId = cateThrId;
	}
	private Integer productId;
	private String productName;
	private String productDesc;
	private Integer productStatus;
	private String productStatusName;
	private Date createAt;
	private Date updateAt;
	private String productImgFirst;
	private String productImg;
	private Integer price;
	private Integer stock;
	private Integer saleNum;
	private Integer nowNum;
	
	private Integer brandId;
	private Integer cateThrId;
	
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
	public Integer getBrandId() {
		return brandId;
	}
	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}
	public Integer getCateThrId() {
		return cateThrId;
	}
	public void setCateThrId(Integer cateThrId) {
		this.cateThrId = cateThrId;
	}
}

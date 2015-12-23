package com.my.mysql.form;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;


public class ProductForm extends BaseForm{
	
	@NotNull(message = "id不能为空！", groups = {addCateSecForm.class,addProductForm.class})
	private Integer categoryId;
	@NotEmpty(message = "名称不能为空！", groups = {addCategoryForm.class,addCateSecForm.class})
	private String categoryName;
	@NotEmpty(message = "描述不能为空！", groups = {addCategoryForm.class,addCateSecForm.class})
	private String categoryDesc;
//	@NotEmpty(message = "用户名不能为空！", groups = {addCategoryForm.class})
	private Integer categoryIndex;
	@NotEmpty(message = "图片地址不能为空！", groups = {addCategoryForm.class,addCateSecForm.class})
	private String categoryImg;
	
	@NotEmpty(message = "品牌名称不能为空！", groups = {addBrandForm.class})
	private String brandName;
	@NotEmpty(message = "品牌描述不能为空！", groups = {addBrandForm.class})
	private String brandDesc;
	
	@NotNull(message = "id不能为空！", groups = {addProductForm.class})
	private Integer brandId;
	@NotEmpty(message = "商品名称不能为空！", groups = {addProductForm.class})
	private String productName;
	@NotEmpty(message = "商品描述不能为空！", groups = {addProductForm.class})
	private String productDesc;
	@NotEmpty(message = "商品默认图片不能为空！", groups = {addProductForm.class})
	private String productImgFirst;
	private String productImg;
	//
	@NotNull(message = "价格不能为空！", groups = {addProductForm.class})
	private Integer price;
	//库存
	@NotNull(message = "库存不能为空！", groups = {addProductForm.class})
	private Integer stock;
	
	//搜索词汇
	private Integer productStatus;
	
	private Integer status;
	private String startTime;
	private String endTime;
	
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryDesc() {
		return categoryDesc;
	}
	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}
	public Integer getCategoryIndex() {
		return categoryIndex;
	}
	public void setCategoryIndex(Integer categoryIndex) {
		this.categoryIndex = categoryIndex;
	}
	public String getCategoryImg() {
		return categoryImg;
	}
	public void setCategoryImg(String categoryImg) {
		this.categoryImg = categoryImg;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getBrandDesc() {
		return brandDesc;
	}
	public void setBrandDesc(String brandDesc) {
		this.brandDesc = brandDesc;
	}
	public Integer getBrandId() {
		return brandId;
	}
	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
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
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getProductStatus() {
		return productStatus;
	}
	public void setProductStatus(Integer productStatus) {
		this.productStatus = productStatus;
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
}

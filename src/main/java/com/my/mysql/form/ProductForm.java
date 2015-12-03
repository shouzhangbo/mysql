package com.my.mysql.form;

import org.hibernate.validator.constraints.NotEmpty;


public class ProductForm extends BaseForm{
	
	@NotEmpty(message = "id不能为空！", groups = {addCateSecForm.class,addProductForm.class})
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
	
	@NotEmpty(message = "id不能为空！", groups = {addProductForm.class})
	private Integer brandId;
	@NotEmpty(message = "商品名称不能为空！", groups = {addProductForm.class})
	private String productName;
	@NotEmpty(message = "商品描述不能为空！", groups = {addProductForm.class})
	private String productDesc;
	@NotEmpty(message = "商品默认图片不能为空！", groups = {addProductForm.class})
	private String productImgFirst;
	private String productImg;
	
	
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
}

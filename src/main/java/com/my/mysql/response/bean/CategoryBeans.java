package com.my.mysql.response.bean;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.my.mysql.model.CategorySec;
import com.my.mysql.response.CategorySecResponse;

public class CategoryBeans {

	private Integer categoryId;
	private String categoryName;
	private String categoryDesc;
	private Integer categoryIndex;
	private String categoryImg;
	private Date createAt;
	private Date updateAt;
	private Integer status;
	private String statusName;
	
	private Set<CategorySecBeans> secList;
	
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
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
	public Set<CategorySecBeans> getSecList() {
		return secList;
	}
	public void setSecList(Set<CategorySecBeans> secList) {
		this.secList = secList;
	}
}

package com.my.mysql.response.bean;

import java.util.Date;
import java.util.List;
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

public class CategorySecBeans {
	private Integer cateSecId;
	private String cateSecName;
	private String cateSecDesc;
	private Integer cateSecIndex;
	private String cateSecImg;
	private Date createAt;
	private Date updateAt;
	private Integer status;
	private String statusName;
	
	private List<CategoryThrBeans> categoryThr;
	
	public Integer getCateSecId() {
		return cateSecId;
	}
	public void setCateSecId(Integer cateSecId) {
		this.cateSecId = cateSecId;
	}
	public String getCateSecName() {
		return cateSecName;
	}
	public void setCateSecName(String cateSecName) {
		this.cateSecName = cateSecName;
	}
	public String getCateSecDesc() {
		return cateSecDesc;
	}
	public void setCateSecDesc(String cateSecDesc) {
		this.cateSecDesc = cateSecDesc;
	}
	public Integer getCateSecIndex() {
		return cateSecIndex;
	}
	public void setCateSecIndex(Integer cateSecIndex) {
		this.cateSecIndex = cateSecIndex;
	}
	public String getCateSecImg() {
		return cateSecImg;
	}
	public void setCateSecImg(String cateSecImg) {
		this.cateSecImg = cateSecImg;
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
	public List<CategoryThrBeans> getCategoryThr() {
		return categoryThr;
	}
	public void setCategoryThr(List<CategoryThrBeans> categoryThr) {
		this.categoryThr = categoryThr;
	}
}

package com.my.mysql.response.bean;

import java.util.Date;

public class CategoryThrBeans {
	private Integer cateThrId;
	private String cateThrName;
	private String cateThrDesc;
	private Integer cateThrIndex;
	private String cateThrImg;
	private Date createAt;
	private Date updateAt;
	private Integer status;
	private String statusName;
	
	public Integer getCateThrId() {
		return cateThrId;
	}
	public void setCateThrId(Integer cateThrId) {
		this.cateThrId = cateThrId;
	}
	public String getCateThrName() {
		return cateThrName;
	}
	public void setCateThrName(String cateThrName) {
		this.cateThrName = cateThrName;
	}
	public String getCateThrDesc() {
		return cateThrDesc;
	}
	public void setCateThrDesc(String cateThrDesc) {
		this.cateThrDesc = cateThrDesc;
	}
	public Integer getCateThrIndex() {
		return cateThrIndex;
	}
	public void setCateThrIndex(Integer cateThrIndex) {
		this.cateThrIndex = cateThrIndex;
	}
	public String getCateThrImg() {
		return cateThrImg;
	}
	public void setCateThrImg(String cateThrImg) {
		this.cateThrImg = cateThrImg;
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
}

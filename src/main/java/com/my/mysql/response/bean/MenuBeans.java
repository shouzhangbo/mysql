package com.my.mysql.response.bean;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;

public class MenuBeans {

	private Integer menuId;
	private String menuName;
	private String menuIco;
	private Integer indexs;
	private Integer status;
	private String statusName;
	private Date createAt;
	private Date updateAt;
	private List<PageBeans> pageList;
	
	public Integer getMenuId() {
		return menuId;
	}
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuIco() {
		return menuIco;
	}
	public void setMenuIco(String menuIco) {
		this.menuIco = menuIco;
	}
	public Integer getIndexs() {
		return indexs;
	}
	public void setIndexs(Integer indexs) {
		this.indexs = indexs;
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
	public List<PageBeans> getPageList() {
		return pageList;
	}
	public void setPageList(List<PageBeans> pageList) {
		this.pageList = pageList;
	}
}

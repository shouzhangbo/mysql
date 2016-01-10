package com.my.mysql.response.bean;

import java.util.Date;
import java.util.List;

public class RoleBeans {

	private Integer roleId;
	private String roleName;
	private Integer status;
	private String statusName;
	private Date createAt;
	private Date updateAt;
	private List<MenuBeans> list;
	
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
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
	public List<MenuBeans> getList() {
		return list;
	}
	public void setList(List<MenuBeans> list) {
		this.list = list;
	}
}

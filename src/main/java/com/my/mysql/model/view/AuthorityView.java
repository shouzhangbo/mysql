package com.my.mysql.model.view;

import java.util.Date;

public class AuthorityView {

	public AuthorityView(){}
	public AuthorityView(Integer roleId,String roleName,Integer roleStatus,String roleStatusName,
			Integer authorityId,Date createAt,Date updateAt,Integer pageId,String pageName,String pageIco,
			String pageUrl,Integer indexs,Integer status,String statusName)
	{
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleStatus = roleStatus;
		this.roleStatusName = roleStatusName;
		this.authorityId = authorityId;
		this.createAt = createAt;
		this.updateAt = updateAt;
		this.pageId = pageId;
		this.pageName = pageName;
		this.pageIco = pageIco;
		this.pageUrl = pageUrl;
		this.indexs = indexs;
		this.status = status;
		this.statusName = statusName;
	}
	private Integer roleId;
	private String roleName;
	private Integer roleStatus;
	private String roleStatusName;
	
	private Integer authorityId;
	private Date createAt;
	private Date updateAt;
	
	private Integer pageId;
	private String pageName;
	private String pageIco;
	private String pageUrl;
	private Integer indexs;
	private Integer status;
	private String statusName;
	
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
	public Integer getRoleStatus() {
		return roleStatus;
	}
	public void setRoleStatus(Integer roleStatus) {
		this.roleStatus = roleStatus;
	}
	public String getRoleStatusName() {
		return roleStatusName;
	}
	public void setRoleStatusName(String roleStatusName) {
		this.roleStatusName = roleStatusName;
	}
	public Integer getAuthorityId() {
		return authorityId;
	}
	public void setAuthorityId(Integer authorityId) {
		this.authorityId = authorityId;
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
	public Integer getPageId() {
		return pageId;
	}
	public void setPageId(Integer pageId) {
		this.pageId = pageId;
	}
	public String getPageName() {
		return pageName;
	}
	public void setPageName(String pageName) {
		this.pageName = pageName;
	}
	public String getPageIco() {
		return pageIco;
	}
	public void setPageIco(String pageIco) {
		this.pageIco = pageIco;
	}
	public String getPageUrl() {
		return pageUrl;
	}
	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
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
}

package com.my.mysql.model;

import java.util.Date;
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

import org.hibernate.annotations.Cascade;

@Entity   
@Table(name="page")
public class Page {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "page_id",length=11)
	private Integer pageId;
	@Column(name = "page_name",length=12)
	private String pageName;
	@Column(name = "page_ico",length=100)
	private String pageIco;
	@Column(name = "page_url",length=100)
	private String pageUrl;
	@Column(name = "indexs",length=4)
	private Integer indexs;
	@Column(name = "status",length=2)
	private Integer status;
	@Column(name = "status_name",length=32)
	private String statusName;
	@Column(name = "create_at", nullable = false)
	private Date createAt;
	@Column(name = "update_at", nullable = false)
	private Date updateAt;
	
	@ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.MERGE }, optional = true)
	@JoinColumn(name = "menu_id")
	private Menu menu;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "auPage")
	@Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE,org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
	private Set<Authority> authority;
	
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
	public String getPageUrl() {
		return pageUrl;
	}
	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	public Set<Authority> getAuthority() {
		return authority;
	}
	public void setAuthority(Set<Authority> authority) {
		this.authority = authority;
	}
}

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity   
@Table(name="menu")
public class Menu {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "menu_id",length=11)
	private Integer menuId;
	@Column(name = "menu_name",length=12)
	private String menuName;
	@Column(name = "menu_ico",length=100)
	private String menuIco;
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
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "menu")
	@Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE,org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
	private Set<Page> page;
	
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
	public Set<Page> getPage() {
		return page;
	}
	public void setPage(Set<Page> page) {
		this.page = page;
	}
}

package com.my.mysql.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity   
@Table(name="authority")
public class Authority {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "authority_id",length=11)
	private Integer authorityId;
	@Column(name = "create_at", nullable = false)
	private Date createAt;
	@Column(name = "update_at", nullable = false)
	private Date updateAt;
	
	@ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.MERGE }, optional = true)
	@JoinColumn(name = "page_id")
	private Page auPage;
	
	@ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.MERGE }, optional = true)
	@JoinColumn(name = "role_id")
	private Role auRole;

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

	public Page getAuPage() {
		return auPage;
	}

	public void setAuPage(Page auPage) {
		this.auPage = auPage;
	}

	public Role getAuRole() {
		return auRole;
	}

	public void setAuRole(Role auRole) {
		this.auRole = auRole;
	}
}

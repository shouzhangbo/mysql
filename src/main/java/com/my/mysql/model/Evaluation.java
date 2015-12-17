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

@Entity   
@Table(name="eval")
public class Evaluation {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "eval_id",length=11)
	private Integer evalId;
	@Column(name = "status",length=2)
	private Integer status;
	@Column(name = "status_name",length=32)
	private String statusName;
	@Column(name = "level",length=32)
	private String level;
	@Column(name = "content",length=1024)
	private String content;
	@Column(name = "Create_at", nullable = false)
	private Date CreateAt;
	@Column(name = "Update_at", nullable = false)
	private Date UpdateAt;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "evaluation")
	private Set<Order> orderInfo;
	
	@ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.MERGE }, optional = true)
	@JoinColumn(name = "base_user_id")
	private BaseUser baseEval;
	public Integer getEvalId() {
		return evalId;
	}
	public void setEvalId(Integer evalId) {
		this.evalId = evalId;
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
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateAt() {
		return CreateAt;
	}
	public void setCreateAt(Date createAt) {
		CreateAt = createAt;
	}

	public Date getUpdateAt() {
		return UpdateAt;
	}
	public void setUpdateAt(Date updateAt) {
		UpdateAt = updateAt;
	}
	public Set<Order> getOrderInfo() {
		return orderInfo;
	}

	public void setOrderInfo(Set<Order> orderInfo) {
		this.orderInfo = orderInfo;
	}
	public BaseUser getBaseEval() {
		return baseEval;
	}
	public void setBaseEval(BaseUser baseEval) {
		this.baseEval = baseEval;
	}
}

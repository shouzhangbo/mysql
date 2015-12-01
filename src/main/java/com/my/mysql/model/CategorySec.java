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
@Table(name="category_sec")
public class CategorySec {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cate_sec_id",length=11)
	private Integer cateSecId;
	@Column(name = "cate_sec_name",length=64)
	private String cateSecName;
	@Column(name = "cate_sec_desc",length=512)
	private String cateSecDesc;
	@Column(name = "cate_sec_index",length=10)
	private Integer cateSecIndex;
	@Column(name = "cate_sec_img",length=128)
	private String cateSecImg;
	@Column(name = "create_at")
	private Date createAt;
	@Column(name = "update_at")
	private Date updateAt;
	
	@ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.MERGE }, optional = true)
	@JoinColumn(name = "category_id")
	private Category category;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "categorySec")
	private Set<CategoryThr> categoryThr;
	
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
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Set<CategoryThr> getCategoryThr() {
		return categoryThr;
	}
	public void setCategoryThr(Set<CategoryThr> categoryThr) {
		this.categoryThr = categoryThr;
	}
}

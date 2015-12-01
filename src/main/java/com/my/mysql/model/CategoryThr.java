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
@Table(name="category_thr")
public class CategoryThr {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cate_thr_id",length=11)
	private Integer cateThrId;
	@Column(name = "cate_thr_name",length=64)
	private String cateThrName;
	@Column(name = "cate_thr_desc",length=512)
	private String cateThrDesc;
	@Column(name = "cate_thr_index",length=10)
	private Integer cateThrIndex;
	@Column(name = "cate_thr_img",length=128)
	private String cateThrImg;
	@Column(name = "create_at")
	private Date createAt;
	@Column(name = "update_at")
	private Date updateAt;
	
	@ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.MERGE }, optional = true)
	@JoinColumn(name = "cate_sec_id")
	private CategorySec categorySec;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "categoryThr")
	private Set<Product> product;
	
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
	public CategorySec getCategorySec() {
		return categorySec;
	}
	public void setCategorySec(CategorySec categorySec) {
		this.categorySec = categorySec;
	}
	public Set<Product> getProduct() {
		return product;
	}
	public void setProduct(Set<Product> product) {
		this.product = product;
	}
}

package com.my.mysql.form;

public class BaseForm {

	private Integer pageSize;
	private Integer currentPage;
	
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public interface resigerForm{}
	public interface isResigerForm{}
	public interface perfectRegister{}
	public interface addCategoryForm{}
	public interface addCateSecForm{}
	
	public interface addBrandForm{}
	public interface addProductForm{}
}

package com.my.mysql.response;

import java.util.List;

import com.my.mysql.response.bean.CategoryBeans;

public class CategoryResponse extends BaseResponse{

	private List<CategoryBeans> list;

	public List<CategoryBeans> getList() {
		return list;
	}

	public void setList(List<CategoryBeans> list) {
		this.list = list;
	}
	
}

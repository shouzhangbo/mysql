package com.my.mysql.response;

import java.util.Date;
import java.util.List;

import com.my.mysql.response.bean.CategoryThrBeans;

public class CategoryThrResponse extends BaseResponse{
	private List<CategoryThrBeans> list;

	public List<CategoryThrBeans> getList() {
		return list;
	}
	public void setList(List<CategoryThrBeans> list) {
		this.list = list;
	}
}

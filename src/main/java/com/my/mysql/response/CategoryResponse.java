package com.my.mysql.response;

import java.util.List;

import com.my.mysql.model.Category;
import com.my.mysql.model.CategorySec;

public class CategoryResponse extends BaseResponse {
	private List<Category> list;

	public List<Category> getList() {
		return list;
	}

	public void setList(List<Category> list) {
		this.list = list;
	}
}

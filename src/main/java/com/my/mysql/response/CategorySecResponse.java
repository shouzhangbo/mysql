package com.my.mysql.response;

import java.util.List;

import com.my.mysql.model.CategorySec;
import com.my.mysql.model.CategoryThr;

public class CategorySecResponse extends BaseResponse {
	private List<CategorySec> list;

	public List<CategorySec> getList() {
		return list;
	}

	public void setList(List<CategorySec> list) {
		this.list = list;
	}
}

package com.my.mysql.response;

import java.util.List;

import com.my.mysql.model.CategoryThr;
import com.my.mysql.model.Product;

public class CategoryThrponse  extends BaseResponse{
	private List<CategoryThr> list;

	public List<CategoryThr> getList() {
		return list;
	}

	public void setList(List<CategoryThr> list) {
		this.list = list;
	}
}

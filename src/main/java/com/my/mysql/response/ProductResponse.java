package com.my.mysql.response;

import java.util.List;

import com.my.mysql.model.Product;

public class ProductResponse extends BaseResponse{

	private List<Product> list;

	public List<Product> getList() {
		return list;
	}

	public void setList(List<Product> list) {
		this.list = list;
	}
	
}

package com.my.mysql.response;

import java.util.List;

import com.my.mysql.model.Product;
import com.my.mysql.response.bean.ProductBeans;

public class ProductResponse extends BaseResponse{

	private List<ProductBeans> list;

	public List<ProductBeans> getList() {
		return list;
	}

	public void setList(List<ProductBeans> list) {
		this.list = list;
	}
	
}

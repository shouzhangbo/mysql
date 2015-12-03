package com.my.mysql.response;

import java.util.List;

import com.my.mysql.model.Brand;

public class BrandResponse  extends BaseResponse{
	private List<Brand> list;

	public List<Brand> getList() {
		return list;
	}

	public void setList(List<Brand> list) {
		this.list = list;
	}
}

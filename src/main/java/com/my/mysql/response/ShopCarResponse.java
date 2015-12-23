package com.my.mysql.response;

import java.util.List;

import com.my.mysql.response.bean.ProductBean;

public class ShopCarResponse extends BaseResponse{

	private List<ProductBean> list;
	public List<ProductBean> getList() {
		return list;
	}
	public void setList(List<ProductBean> list) {
		this.list = list;
	}
}

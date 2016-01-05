package com.my.mysql.response;

import java.util.List;

import com.my.mysql.response.BaseResponse;
import com.my.mysql.response.bean.OrderBeans;

public class OrderResponse extends BaseResponse{

	private List<OrderBeans> list;

	public List<OrderBeans> getList() {
		return list;
	}
	public void setList(List<OrderBeans> list) {
		this.list = list;
	}
	
}

package com.my.mysql.ctrl;

import java.util.List;

import com.my.mysql.ctrl.bg.OrderBeans;
import com.my.mysql.response.BaseResponse;

public class OrderResponse extends BaseResponse{

	private List<OrderBeans> list;

	public List<OrderBeans> getList() {
		return list;
	}
	public void setList(List<OrderBeans> list) {
		this.list = list;
	}
	
}

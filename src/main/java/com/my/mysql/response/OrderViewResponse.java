package com.my.mysql.response;

import java.util.List;

import com.my.mysql.model.view.OrderView;

public class OrderViewResponse extends BaseResponse{

	private List<OrderView> list;

	public List<OrderView> getList() {
		return list;
	}
	public void setList(List<OrderView> list) {
		this.list = list;
	}
	
}

package com.my.mysql.ctrl;

import java.util.List;

import com.my.mysql.ctrl.bg.OrderInfoBeans;
import com.my.mysql.response.BaseResponse;

public class OrderInfoResponse extends BaseResponse{

	private List<OrderInfoBeans> list;

	public List<OrderInfoBeans> getList() {
		return list;
	}
	public void setList(List<OrderInfoBeans> list) {
		this.list = list;
	}
}

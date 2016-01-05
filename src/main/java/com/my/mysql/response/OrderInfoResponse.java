package com.my.mysql.response;

import java.util.List;

import com.my.mysql.response.BaseResponse;
import com.my.mysql.response.bean.OrderInfoBeans;

public class OrderInfoResponse extends BaseResponse{

	private List<OrderInfoBeans> list;

	public List<OrderInfoBeans> getList() {
		return list;
	}
	public void setList(List<OrderInfoBeans> list) {
		this.list = list;
	}
}

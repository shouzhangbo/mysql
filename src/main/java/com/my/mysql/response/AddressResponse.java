package com.my.mysql.response;

import java.util.List;

import com.my.mysql.response.bean.AddressBeans;

public class AddressResponse extends BaseResponse{

	private List<AddressBeans> list;

	public List<AddressBeans> getList() {
		return list;
	}
	public void setList(List<AddressBeans> list) {
		this.list = list;
	}
	
}

package com.my.mysql.response;

import java.util.List;

import com.my.mysql.response.bean.AuthorityBeans;

public class AuthorityResponse extends BaseResponse{

	private List<AuthorityBeans> list;

	public List<AuthorityBeans> getList() {
		return list;
	}
	public void setList(List<AuthorityBeans> list) {
		this.list = list;
	}
}

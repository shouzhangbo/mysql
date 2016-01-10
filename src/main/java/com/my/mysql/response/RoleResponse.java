package com.my.mysql.response;

import java.util.List;

import com.my.mysql.response.bean.RoleBeans;

public class RoleResponse extends BaseResponse{

	private List<RoleBeans> list;

	public List<RoleBeans> getList() {
		return list;
	}
	public void setList(List<RoleBeans> list) {
		this.list = list;
	}
	
}

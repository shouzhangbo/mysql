package com.my.mysql.response;

import java.util.List;

import com.my.mysql.response.bean.MgUserBeans;

public class MgUserResponse extends BaseResponse{

	List<MgUserBeans> list;

	public List<MgUserBeans> getList() {
		return list;
	}

	public void setList(List<MgUserBeans> list) {
		this.list = list;
	}
	
}

package com.my.mysql.response;

import java.util.List;

import com.my.mysql.response.bean.MenuBeans;

public class MenuResponse  extends BaseResponse{

	private List<MenuBeans> list;

	public List<MenuBeans> getList() {
		return list;
	}
	public void setList(List<MenuBeans> list) {
		this.list = list;
	}
	
}

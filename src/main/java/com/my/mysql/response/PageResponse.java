package com.my.mysql.response;

import java.util.List;

import com.my.mysql.response.bean.PageBeans;

public class PageResponse extends BaseResponse{

	List<PageBeans> list;

	public List<PageBeans> getList() {
		return list;
	}

	public void setList(List<PageBeans> list) {
		this.list = list;
	}
	
}

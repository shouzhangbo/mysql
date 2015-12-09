package com.my.mysql.response;

import java.util.List;
import com.my.mysql.response.bean.CategorySecBeans;

public class CategorySecResponse extends BaseResponse {
	private List<CategorySecBeans> list;

	public List<CategorySecBeans> getList() {
		return list;
	}

	public void setList(List<CategorySecBeans> list) {
		this.list = list;
	}
	
}

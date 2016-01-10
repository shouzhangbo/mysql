package com.my.mysql.service;

import java.util.List;

import com.my.mysql.model.Page;

public interface PageService extends BaseService<Page> {

	public List<Page> query(Page pageForm);
}

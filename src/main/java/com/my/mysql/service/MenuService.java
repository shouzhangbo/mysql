package com.my.mysql.service;

import java.util.List;

import com.my.mysql.model.Menu;

public interface MenuService extends BaseService<Menu>{

	public List<Menu> query(Menu menuFor);
}

package com.my.mysql.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.my.mysql.model.Menu;
import com.my.mysql.model.Page;
import com.my.mysql.service.MenuService;
@Service
public class MenuServiceImpl extends BaseServiceImpl<Menu> implements MenuService{

	@Override
	public List<Menu> query(Menu menuFor) {
		List<Menu> list = new ArrayList<Menu>();
		String hql = "from Menu where 1=1";
		Map<String,Object> map = new HashMap<String,Object>();
		list = baseDao.find(hql, map);
		return list;
	}

}

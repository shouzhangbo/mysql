package com.my.mysql.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.my.mysql.model.Page;
import com.my.mysql.service.PageService;
@Service
public class PageServiceImpl extends BaseServiceImpl<Page> implements PageService{

	@Override
	public List<Page> query(Page pageForm) {
		List<Page> list = new ArrayList<Page>();
		String hql = "from Page where 1=1";
		Map<String,Object> map = new HashMap<String,Object>();
		list = baseDao.find(hql, map);
		return list;
	}

}

package com.my.mysql.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.my.mysql.model.Role;
import com.my.mysql.service.RoleService;

@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService{

	@Override
	public List<Role> query(Role roleForm) {
		List<Role> list = new ArrayList<Role>();
		String hql = "from Role where 1=1";
		Map<String,Object> map = new HashMap<String,Object>();
		list = baseDao.find(hql, map);
		return list;
	}

}

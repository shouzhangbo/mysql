package com.my.mysql.service.impl;

import java.util.*;

import org.springframework.stereotype.Service;

import com.my.mysql.form.bg.UserForm;
import com.my.mysql.model.MgUser;
import com.my.mysql.service.MgUserService;

@Service
public class MgUserServiceImpl extends BaseServiceImpl<MgUser> implements MgUserService{

	@Override
	public List<MgUser> queryByUserName(UserForm userForm) {
		List<MgUser> list = new ArrayList<MgUser>();
		String hql = "from MgUser where mgUserName=:mgUserName and mgPsd=:mgPsd";
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("mgUserName", userForm.getUserName());
		map.put("mgPsd", userForm.getUserPsd());
		list = baseDao.find(hql, map);
		return list;
	}

}

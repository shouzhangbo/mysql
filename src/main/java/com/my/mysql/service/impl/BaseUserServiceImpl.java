package com.my.mysql.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.my.mysql.model.BaseUser;
import com.my.mysql.model.UserInfo;
import com.my.mysql.service.BaseUserService;
@Service
public class BaseUserServiceImpl extends BaseServiceImpl<BaseUser> implements BaseUserService {

	public List<BaseUser> getUserByName(String userName){
		List<BaseUser> list = new ArrayList<BaseUser>();
		list = baseDao.findByProperty(BaseUser.class,"userName",userName);
		return list;
	}
}

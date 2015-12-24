package com.my.mysql.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.my.mysql.constants.GlobalConstant;
import com.my.mysql.form.ResigerForm;
import com.my.mysql.model.BaseUser;
import com.my.mysql.model.UserInfo;
import com.my.mysql.service.BaseUserService;
import com.my.mysql.util.CommUtil;
@Service
public class BaseUserServiceImpl extends BaseServiceImpl<BaseUser> implements BaseUserService {

	public List<BaseUser> getUserByName(String userName){
		List<BaseUser> list = new ArrayList<BaseUser>();
		list = baseDao.findByProperty(BaseUser.class,"userName",userName);
		return list;
	}

	@Override
	public BaseUser queryUser(ResigerForm user) {
		Map<String,Object> map = new HashMap<String,Object>();
		String sql = "from BaseUser where userName=:userName and basePsd=:basePsd and status=:status";
		map.put("userName", user.getUserName());
		map.put("basePsd", user.getBaseUserPsd());
		map.put("status", GlobalConstant.okInt);
		List<BaseUser> list = baseDao.find(sql, map);
		if(!CommUtil.isEmpty(list)&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
}

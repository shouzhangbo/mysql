package com.my.mysql.service;

import java.util.List;

import com.my.mysql.form.ResigerForm;
import com.my.mysql.model.BaseUser;
import com.my.mysql.model.UserInfo;

public interface BaseUserService extends BaseService<BaseUser>{

	public List<BaseUser> getUserByName(String userName);
	public BaseUser queryUser(ResigerForm user);
}

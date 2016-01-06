package com.my.mysql.service;

import java.util.*;

import com.my.mysql.form.bg.UserForm;
import com.my.mysql.model.MgUser;

public interface MgUserService extends BaseService<MgUser>{

	public List<MgUser> queryByUserName(UserForm userForm);
}

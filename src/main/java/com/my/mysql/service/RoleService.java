package com.my.mysql.service;

import java.util.List;

import com.my.mysql.model.Role;

public interface RoleService extends BaseService<Role>{

	
	public List<Role> query(Role roleForm);
}

package com.my.mysql.service;

import java.util.List;

import com.my.mysql.form.AuthorityForm;
import com.my.mysql.model.Authority;
import com.my.mysql.model.view.AuthorityView;

public interface AuthorityService extends BaseService<Authority>{

	public List<Authority> query(Authority auForm);
	
	public List<AuthorityView> queryByCond(AuthorityForm auForm);
}

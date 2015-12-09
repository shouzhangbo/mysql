package com.my.mysql.service;

import java.util.List;

import com.my.mysql.form.ProductForm;
import com.my.mysql.model.BaseUser;
import com.my.mysql.model.CategorySec;
import com.my.mysql.model.UserInfo;

public interface CategorySecService extends BaseService<CategorySec>{

	public List<CategorySec> queryCateSec(ProductForm form);
	
	public int queryCateSecCount(ProductForm form);
}

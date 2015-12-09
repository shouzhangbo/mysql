package com.my.mysql.service;

import java.util.List;

import com.my.mysql.form.ProductForm;
import com.my.mysql.model.Category;
import com.my.mysql.model.UserInfo;

public interface CategoryService extends BaseService<Category>{

	public List<Category> queryCategoryByCon(ProductForm form);
	
	public int queryByCount(ProductForm form);
}

package com.my.mysql.service;

import java.util.List;

import com.my.mysql.form.ProductForm;
import com.my.mysql.model.CategoryThr;

public interface CategoryThrService extends BaseService<CategoryThr>{
	
	public List<CategoryThr> queryCateSec(ProductForm form);
	
	public int queryCateSecCount(ProductForm form);
}

package com.my.mysql.service;

import java.util.List;

import com.my.mysql.form.ProductForm;
import com.my.mysql.model.BaseUser;
import com.my.mysql.model.Product;
import com.my.mysql.model.UserInfo;

public interface ProductService extends BaseService<Product>{

	public List<Product> queryProduct(ProductForm form);
	public int queryProductByCount(ProductForm form);
}

package com.my.mysql.service;

import java.util.List;

import com.my.mysql.form.ProductForm;
import com.my.mysql.model.BaseUser;
import com.my.mysql.model.Product;
import com.my.mysql.model.UserInfo;
import com.my.mysql.model.view.ProductView;

public interface ProductService extends BaseService<Product>{

	public List<Product> queryProduct(ProductForm form);
	public int queryProductByCount(ProductForm form);
	
	public List<ProductView> queryProductView(ProductForm form);
}

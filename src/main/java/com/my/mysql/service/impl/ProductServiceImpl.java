package com.my.mysql.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.my.mysql.form.ProductForm;
import com.my.mysql.model.Category;
import com.my.mysql.model.Product;
import com.my.mysql.service.CategoryService;
import com.my.mysql.service.ProductService;
@Service
public class ProductServiceImpl extends BaseServiceImpl<Product> implements ProductService {

	@Override
	public List<Product> queryProduct(ProductForm form) {
		
//		baseDao.findByPage(hqlStr, params, pageInfo)
		return null;
	}
	@Override
	public int queryProductByCount(ProductForm form) {
		return 0;
	}
}

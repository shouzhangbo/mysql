package com.my.mysql.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.my.mysql.form.ProductForm;
import com.my.mysql.model.Product;
import com.my.mysql.service.CategoryService;
import com.my.mysql.service.ProductService;
import com.my.mysql.util.CommUtil;
import com.my.mysql.util.PageInfo;
@Service
public class ProductServiceImpl extends BaseServiceImpl<Product> implements ProductService {

	@Override
	public List<Product> queryProduct(ProductForm form) {
		List<Product> list = new ArrayList<Product>();
		String hqlStr = "from Product where 1=1 ";
		Map<String,Object> params = new HashMap<String,Object>();
		try{
			if(!CommUtil.isEmpty(form.getProductName())){
				hqlStr = " and productName like :productName";
				params.put("productName", "%"+form.getProductName()+"%");
			}
			if(!CommUtil.isEmpty(form.getProductStatus())){
				hqlStr = " and productStatus=:productStatus";
				params.put("productStatus",form.getProductStatus());
			}
			if(!CommUtil.isEmpty(form.getStartTime())){
				hqlStr = hqlStr + "createAt >=:createAt";
				params.put(" and createAt", sdf.parse(form.getStartTime()));
			}
			if(!CommUtil.isEmpty(form.getEndTime())){
				hqlStr = hqlStr + "createAt <=:createAt";
				params.put(" and createAt", sdf.parse(form.getEndTime()));
			}
			PageInfo pageInfo = new PageInfo();
			if(CommUtil.isEmpty(form.getPageSize())||0==form.getPageSize()){
				pageInfo.setPageSize(5);
			}else{
				pageInfo.setPageSize(form.getPageSize());
			}
			if(CommUtil.isEmpty(form.getCurrentPage())||0==form.getCurrentPage()){
				pageInfo.setCurrentPage(1);
			}else{
				pageInfo.setCurrentPage(form.getCurrentPage());
			}
			list = baseDao.findByPage(hqlStr, params, pageInfo);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public int queryProductByCount(ProductForm form) {
		List<Product> list = new ArrayList<Product>();
		String hqlStr = "from Product where 1=1 ";
		Map<String,Object> params = new HashMap<String,Object>();
		try{
			if(!CommUtil.isEmpty(form.getProductName())){
				hqlStr = " and productName like :productName";
				params.put("productName", "%"+form.getProductName()+"%");
			}
			if(!CommUtil.isEmpty(form.getProductStatus())){
				hqlStr = " and productStatus=:productStatus";
				params.put("productStatus",form.getProductStatus());
			}
			if(!CommUtil.isEmpty(form.getStartTime())){
				hqlStr = hqlStr + "createAt >=:createAt";
				params.put("createAt", sdf.parse(form.getStartTime()));
			}
			if(!CommUtil.isEmpty(form.getEndTime())){
				hqlStr = hqlStr + "createAt <=:createAt";
				params.put("createAt", sdf.parse(form.getEndTime()));
			}
			list = baseDao.find(hqlStr, params);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list.size();
	}
}

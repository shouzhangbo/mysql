package com.my.mysql.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.my.mysql.form.ProductForm;
import com.my.mysql.model.Product;
import com.my.mysql.model.view.ProductView;
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
				hqlStr = hqlStr + " and productName like :productName";
				params.put("productName", "%"+form.getProductName()+"%");
			}
			if(!CommUtil.isEmpty(form.getProductStatus())){
				if(form.getProductStatus()!=2){
					hqlStr = hqlStr + " and productStatus=:productStatus";
					params.put("productStatus",form.getProductStatus());
				}
			}
			if(!CommUtil.isEmpty(form.getStartTime())){
				hqlStr = hqlStr + " and createAt >=:createAt";
				params.put("createAt", sdf.parse(form.getStartTime()));
			}
			if(!CommUtil.isEmpty(form.getEndTime())){
				hqlStr = hqlStr + " and createAt <=:createAt";
				params.put("createAt", sdf.parse(form.getEndTime()));
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
				if(form.getProductStatus()!=2){
					hqlStr = hqlStr + " and productStatus=:productStatus";
					params.put("productStatus",form.getProductStatus());
				}
			}
			if(!CommUtil.isEmpty(form.getStartTime())){
				hqlStr = hqlStr + " and createAt >=:createAt";
				params.put("createAt", sdf.parse(form.getStartTime()));
			}
			if(!CommUtil.isEmpty(form.getEndTime())){
				hqlStr = hqlStr + " and createAt <=:createAt";
				params.put("createAt", sdf.parse(form.getEndTime()));
			}
			
			list = baseDao.find(hqlStr, params);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list.size();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductView> queryProductView(ProductForm form) {
		List<ProductView> list = new ArrayList<ProductView>();
		String hql = "select new com.my.mysql.model.view.ProductView";
		hql =  hql + " (p.productId as productId,p.productName as productName,";
		hql =  hql + "p.productDesc as productDesc,p.productStatus as productStatus,p.productStatusName as productStatusName,";
		hql =  hql + "p.createAt as createAt,p.updateAt as updateAt,p.productImgFirst as productImgFirst,p.productImg as productImg,";
		hql =  hql + "p.price as price,p.stock as stock,p.saleNum as saleNum,p.nowNum as nowNum,c.cateThrId as cateThrId,b.brandId as brandId)";
		hql =  hql + " from Product p,CategoryThr c,Brand b where 1=1 ";
		if(!CommUtil.isEmpty(form.getCategoryId())){
			hql =  hql + " and c.cateThrId="+form.getCategoryId();
		}
		if(!CommUtil.isEmpty(form.getStartTime())){
			hql = hql + " and p.createAt >="+form.getStartTime();
		}
		if(!CommUtil.isEmpty(form.getEndTime())){
			hql = hql + " and p.createAt <=" + form.getEndTime();
		}
		if(!CommUtil.isEmpty(form.getProductName())){
			hql = hql + " and p.productName like '%"+form.getProductName()+"%'";
		}
		if(!CommUtil.isEmpty(form.getProductStatus())){
			if(form.getProductStatus()!=2){
				hql = hql + " and p.productStatus=" + form.getProductStatus();
			}
		}
		System.out.println("hql="+hql);
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
		list = baseDao.findModelViewByPage(hql, pageInfo);
		return list;
	}
}

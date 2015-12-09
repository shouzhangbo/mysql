package com.my.mysql.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.my.mysql.form.ProductForm;
import com.my.mysql.model.Category;
import com.my.mysql.model.CategorySec;
import com.my.mysql.service.CategorySecService;
import com.my.mysql.util.CommUtil;
import com.my.mysql.util.PageInfo;
@Service
public class CategorySecServiceImpl extends BaseServiceImpl<CategorySec> implements CategorySecService {

	@Override
	public List<CategorySec> queryCateSec(ProductForm form) {
		List<CategorySec> list = new ArrayList<CategorySec>();
		Map<String, Object> params = new HashMap<String, Object>();
		String hqlStr = "from CategorySec where 1=1 ";
		try {
			if(!CommUtil.isEmpty(form.getCategoryName())){
				hqlStr = hqlStr + "and cateSecName like :cateSecName ";
				params.put("cateSecName", "%"+form.getCategoryName()+"%");
			}
			if(!CommUtil.isEmpty(form.getStatus())){
				if(2!=form.getStatus()){
					hqlStr = hqlStr + "and status =:status ";
					params.put("status", form.getStatus());
				}
			}
			if(!CommUtil.isEmpty(form.getStartTime())){
				hqlStr = hqlStr + "createAt >=:createAt";
				params.put("createAt", sdf.parse(form.getStartTime()));
			}
			if(!CommUtil.isEmpty(form.getEndTime())){
				hqlStr = hqlStr + "createAt <=:createAt";
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
			System.out.println("hqlStr="+hqlStr);
			list = baseDao.findByPage(hqlStr, params, pageInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public int queryCateSecCount(ProductForm form) {
		List<CategorySec> list = new ArrayList<CategorySec>();
		Map<String, Object> params = new HashMap<String, Object>();
		String hqlStr = "from CategorySec where 1=1 ";
		try {
			if(!CommUtil.isEmpty(form.getCategoryName())){
				hqlStr = hqlStr + "and cateSecName like :cateSecName ";
				params.put("cateSecName", "%"+form.getCategoryName()+"%");
			}
			if(!CommUtil.isEmpty(form.getStatus())){
				if(2!=form.getStatus()){
					hqlStr = hqlStr + "and status =:status ";
					params.put("status", form.getStatus());
				}
			}
			if(!CommUtil.isEmpty(form.getStartTime())){
				hqlStr = hqlStr + "createAt >=:createAt";
				params.put("createAt", sdf.parse(form.getStartTime()));
			}
			if(!CommUtil.isEmpty(form.getEndTime())){
				hqlStr = hqlStr + "createAt <=:createAt";
				params.put("createAt", sdf.parse(form.getEndTime()));
			}
			System.out.println("hqlStr="+hqlStr);
			list = baseDao.find(hqlStr, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list.size();
	}
}

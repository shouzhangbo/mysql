package com.my.mysql.service.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.my.mysql.form.OrderForm;
import com.my.mysql.model.Order;
import com.my.mysql.service.OrderService;
import com.my.mysql.util.CommUtil;
import com.my.mysql.util.PageInfo;
@Service
public class OrderServiceImpl extends BaseServiceImpl<Order> implements OrderService{

	@Override
	public List<Order> queryByCond(OrderForm orderForm) {
		List<Order> list = new ArrayList<Order>();
		String hqlStr = "from Order where 1=1 ";
		Map<String,Object> params = new HashMap<String,Object>();
		try {
			if(!CommUtil.isEmpty(orderForm.getStartTime())){
				hqlStr = hqlStr + " and createAt >=:createAt";
				params.put("createAt", sdf.parse(orderForm.getStartTime()));
			}
			if(!CommUtil.isEmpty(orderForm.getEndTime())){
				hqlStr = hqlStr + " and createAt <=:createAt";
				params.put("createAt", sdf.parse(orderForm.getEndTime()));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		PageInfo pageInfo = new PageInfo();
		if(CommUtil.isEmpty(orderForm.getPageSize())||0==orderForm.getPageSize()){
			pageInfo.setPageSize(5);
		}else{
			pageInfo.setPageSize(orderForm.getPageSize());
		}
		if(CommUtil.isEmpty(orderForm.getCurrentPage())||0==orderForm.getCurrentPage()){
			pageInfo.setCurrentPage(1);
		}else{
			pageInfo.setCurrentPage(orderForm.getCurrentPage());
		}
		list = baseDao.findByPage(hqlStr, params, pageInfo);
		return list;
	}

	@Override
	public List<Order> query() {
		List<Order> list = new ArrayList<Order>();
		String hqlStr = "from Order where base_user_id=1";
		Map<String,Object> params = new HashMap<String,Object>();
//		params.put("baseUser", 1);
//		PageInfo pageInfo = new PageInfo();
//		pageInfo.setCurrentPage(1);
//		pageInfo.setPageSize(10);
		System.out.println("hqlStr="+hqlStr);
		list = baseDao.find(hqlStr, params);
		return list;
	}
}

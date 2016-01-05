package com.my.mysql.service.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.my.mysql.form.OrderForm;
import com.my.mysql.model.Order;
import com.my.mysql.model.view.OrderView;
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
	public List<OrderView> queryByView(OrderForm orderForm) {
		List<OrderView> list = new ArrayList<OrderView>();
		StringBuilder hqlStr = new StringBuilder("select new com.my.mysql.model.view.OrderView");
		hqlStr.append(" (o.orderId as orderId,o.status as status,o.statusName as statusName,o.orderPrice as orderPrice,");
		hqlStr.append("o.orderNo as orderNo,o.createAt as createAt,o.updateAt as updateAt,b.baseUserId as baseUserId,");
		hqlStr.append("a.addressId as addressId,e.evalId as evaluationId)");
		hqlStr.append(" from Order o,BaseUser b,Address a, Evaluation e where 1=1");
		
		if(!CommUtil.isEmpty(orderForm.getBaseUserId())){
			hqlStr = hqlStr.append(" and b.baseUserId="+orderForm.getBaseUserId());
		}
		if(!CommUtil.isEmpty(orderForm.getStartTime())){
			hqlStr = hqlStr.append(" and o.createAt>="+orderForm.getStartTime());
		}
		if(!CommUtil.isEmpty(orderForm.getEndTime())){
			hqlStr = hqlStr.append(" and o.createAt <="+orderForm.getEndTime());
		}
		System.out.println("hqlStr="+hqlStr);
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
		list = baseDao.findModelViewByPage(hqlStr.toString(), pageInfo);
		return list;
	}
}

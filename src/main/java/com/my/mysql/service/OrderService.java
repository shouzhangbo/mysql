package com.my.mysql.service;

import java.util.List;

import com.my.mysql.form.OrderForm;
import com.my.mysql.model.Order;
import com.my.mysql.model.view.OrderView;

public interface OrderService  extends BaseService<Order>{

	public List<Order> queryByCond(OrderForm orderForm);
	
	public List<OrderView> queryByView(OrderForm orderForm);
}

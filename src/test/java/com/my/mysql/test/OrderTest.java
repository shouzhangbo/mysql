package com.my.mysql.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.my.mysql.form.ProductForm;
import com.my.mysql.model.Order;
import com.my.mysql.model.view.ProductView;
import com.my.mysql.service.OrderService;
import com.my.mysql.service.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = "classpath:spring-hibernate.xml")
public class OrderTest {

	@Autowired
	private OrderService orderService;
	@Autowired
	private ProductService productService;
	
	@Test
	public void test(){
		ProductForm form = new ProductForm();
		List<ProductView> list = productService.queryProductView(form);
		System.out.println("list=="+list);
		System.out.println("list=="+list.size());
	}
}

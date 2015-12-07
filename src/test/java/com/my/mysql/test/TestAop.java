package com.my.mysql.test;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.my.mysql.model.UserInfo;
import com.my.mysql.service.UserInfoService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = "classpath:spring-hibernate.xml")
public class TestAop {

	@Autowired
	private UserInfoService userService;
	
//	@Test
	public void test(){
		UserInfo user = new UserInfo();
		user.setUpdateAt(new Date());
		user.setUserEmail("ee");
		user.setUserMobile("eeee");
		user.setCreateAt(new Date());
		userService.save(user);
	}
	public static void main(String[] args) {
		//启动Spring容器
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-hibernate.xml");
		//获取service组件
		UserInfoService service = (UserInfoService) context.getBean("userService");
		//以普通的方式调用UserService对象的三个方法
		UserInfo user = new UserInfo();
		user.setUpdateAt(new Date());
		user.setUserEmail("ee");
		user.setUserMobile("eeee");
		user.setCreateAt(new Date());
		//service.get(1L);
		try {
			service.save(user);
//			service.delete(1L);
		} catch (Exception e) {
			System.out.println("Delete user : " + e.getMessage());
		}
	}
}

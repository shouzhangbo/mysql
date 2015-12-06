package com.my.mysql.test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.my.mysql.model.BaseUser;
import com.my.mysql.model.UserInfo;
import com.my.mysql.service.BaseUserService;
import com.my.mysql.service.UserInfoService;

//@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
//@ContextConfiguration(locations = "classpath:spring-hibernate.xml")
public class TestUserInfo {

//	@Autowired
//	private UserInfoService userService;
//	@Autowired
//	private BaseUserService baseUserService;
//	private BaseUser user;
//	private UserInfo userInfo;
//	@Before
//	public void befor(){
//		user = new BaseUser();
//		userInfo = new UserInfo();
//		
//		user.setUserName("houzhangbo");
//		user.setBasePsd("rrrrrrr");
//		user.setCreateAt(new Date());
//		user.setUpdateAt(new Date());
//		
//		Map<String,Object> map = new HashMap<String,Object>(); 
//		List<BaseUser> list = baseUserService.find("from BaseUser where user_name='houzhangbo'", map);
//		userInfo.setUserMobile("111118");
//		userInfo.setUserEmail("213123");
//		userInfo.setCreateAt(new Date());
//		userInfo.setUpdateAt(new Date());
//		userInfo.setBaseInfo(list.get(0));
//	}
////	@Test
//	public void test(){
////			baseUserService.save(user);
////			userService.save(userInfo);
//			
//			List<BaseUser> uList = baseUserService.findByProperty(BaseUser.class, "userName", "houzhangbo");
//			System.out.println("&&&&&&"+uList.size());
//			System.out.println("####"+uList.get(0).getUserName());
//			System.out.println("*********"+uList.get(0).getUserInfo().size());
//	}
//	
//	public UserInfo getUser(){
//		String u = "";
//		for (int i=0;i<2;i++){
//			   char c='a';
//			   u=u+(char)(c+(int)(Math.random()*26));
//			  }
//		return userInfo;
//	}
	
}

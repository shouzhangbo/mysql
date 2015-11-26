package com.my.mysql.ctrl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.mysql.form.BaseForm.resigerForm;
import com.my.mysql.form.ResigerForm;
import com.my.mysql.model.BaseUser;
import com.my.mysql.model.UserInfo;
import com.my.mysql.response.BaseResponse;
import com.my.mysql.service.BaseUserService;
import com.my.mysql.service.UserInfoService;
import com.my.mysql.util.CommUtil;

@Controller
public class UserCtrl {

	@Autowired
	public BaseUserService baseUserService;
	@Autowired
	public UserInfoService userInfiService;
	@RequestMapping(value = "/register", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
	public BaseResponse register(@Validated({resigerForm.class}) ResigerForm userForm, BindingResult result){
		BaseResponse baseRes = new BaseResponse();
		 try {
	            if (result.hasErrors()) {
	                for (org.springframework.validation.ObjectError e : result.getAllErrors()) {
	                    return baseRes;
	                }
	            }
		 }catch(Exception e){
			 
		 }     
		BaseUser user = new BaseUser();
		user.setBasePsd(CommUtil.MD5(userForm.getBaseUserPsd()));
		user.setUserName(userForm.getUserName());
		user.setCreateAt(new Date());
		user.setUpdateAt(new Date());
		baseUserService.save(user);
		return baseRes;
	}
	
	@RequestMapping(value = "/perfectRegister", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
	public BaseResponse perfectRegister(UserInfo userForm,String id){
		BaseResponse baseRes = new BaseResponse();
		
		userForm.setCreateAt(new Date());
		userForm.setUpdateAt(new Date());
		userInfiService.save(userForm);
		return baseRes;
	}
}

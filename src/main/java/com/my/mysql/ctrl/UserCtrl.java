package com.my.mysql.ctrl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.mysql.constants.GlobalConstant;
import com.my.mysql.form.BaseForm.isResigerForm;
import com.my.mysql.form.BaseForm.resigerForm;
import com.my.mysql.form.BaseForm.perfectRegister;
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
	public UserInfoService userInfoService;
	
	/***
	 * 判断是否注册
	 * @param userForm
	 * @param result
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/isRegister", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
	public BaseResponse isRegister(@Validated({isResigerForm.class}) ResigerForm userForm, 
			BindingResult result,HttpServletRequest request,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*" );
		BaseResponse baseRes = new BaseResponse();
		 try {
	            if (result.hasErrors()) {
	                for (ObjectError e : result.getAllErrors()) {
	                	baseRes.setRespMsg(e.getDefaultMessage());
	                    return baseRes;
	                }
	            }
		 }catch(Exception e){
			 baseRes.setRespMsg("网络异常");
			 e.printStackTrace();
		 }
		 List<BaseUser> list = baseUserService.getUserByName(userForm.getUserName());
		 if(CommUtil.isEmpty(list)||list.size()==0){
			 baseRes.setRespCode("0000");
			 baseRes.setRespMsg("恭喜你，可以使用！");
		 }
		 return baseRes;
	}
	/**
	 * 注册
	 * @param userForm
	 * @param result
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/register", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
	public BaseResponse register(@Validated({resigerForm.class}) ResigerForm userForm, 
			BindingResult result,HttpServletRequest request,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*" );
		BaseResponse baseRes = new BaseResponse();
		 try {
	            if (result.hasErrors()) {
	                for (ObjectError e : result.getAllErrors()) {
	                	baseRes.setRespMsg(e.getDefaultMessage());
	                    return baseRes;
	                }
	            }
		 }catch(Exception e){
			 baseRes.setRespMsg("网络异常");
			 e.printStackTrace();
		 }
		BaseUser user = new BaseUser();
		user.setBasePsd(CommUtil.MD5(userForm.getBaseUserPsd()));
		user.setUserName(userForm.getUserName());
		user.setStatus(GlobalConstant.okInt);
		user.setStatusName(GlobalConstant.oKStatusName);
		user.setCreateAt(new Date());
		user.setUpdateAt(new Date());
		baseUserService.save(user);
		
		baseRes.setRespCode("0000");
		baseRes.setRespMsg("success");
		return baseRes;
	}
	/***
	 * 完善信息
	 * @param userForm
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/perfectRegister", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
	public BaseResponse perfectRegister(@Validated({perfectRegister.class}) ResigerForm userForm, 
			BindingResult result,HttpServletRequest request,HttpServletResponse response){
		BaseResponse baseRes = new BaseResponse();
		UserInfo userInfo = new UserInfo();
		BaseUser baseUser = baseUserService.findById(BaseUser.class,userForm.getUserId());
		if(CommUtil.isEmpty(baseUser)){
			return baseRes;
		}
		userInfo.setCreateAt(new Date());
		userInfo.setUpdateAt(new Date());
		userInfoService.save(userInfo);
		return baseRes;
	}
	
}

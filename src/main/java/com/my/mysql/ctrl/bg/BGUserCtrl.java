package com.my.mysql.ctrl.bg;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.mysql.constants.GlobalConstant;
import com.my.mysql.form.bg.UserForm;
import com.my.mysql.model.MgUser;
import com.my.mysql.response.BaseResponse;
import com.my.mysql.service.MgUserService;
import com.my.mysql.service.RoleService;
import com.my.mysql.util.CommUtil;

@Controller
@RequestMapping(value = "/bguser")
public class BGUserCtrl {

	@Autowired
	private MgUserService mgUserService;
	@Autowired
	private RoleService roleService;
	@RequestMapping(value = "login", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
	public BaseResponse login(UserForm userForm,HttpServletRequest request,HttpServletResponse response)
	{
		response.setHeader("Access-Control-Allow-Origin", "*" );
		BaseResponse b = new BaseResponse();
		List<MgUser> list = mgUserService.queryByUserName(userForm);
		if(CommUtil.isEmpty(list)||list.size()<1){
			return b;
		}
		b.setRespCode(GlobalConstant.successRespCode);
		return b;
	}
}

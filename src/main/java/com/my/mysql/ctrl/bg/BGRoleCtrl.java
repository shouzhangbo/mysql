package com.my.mysql.ctrl.bg;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.mysql.constants.GlobalConstant;
import com.my.mysql.model.Role;
import com.my.mysql.response.BaseResponse;
import com.my.mysql.service.RoleService;

@Controller
@RequestMapping(value = "/role")
public class BGRoleCtrl {

	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value = "/add", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
	public BaseResponse add(Role roleForm,HttpServletRequest request,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*" );
		BaseResponse b = new BaseResponse();
		Role role = new Role();
		role.setRoleName(roleForm.getRoleName());
		role.setStatus(GlobalConstant.okInt);
		role.setStatusName("上线");
		role.setCreateAt(new Date());
		role.setUpdateAt(new Date());
		roleService.save(role);
		
		b.setRespCode(GlobalConstant.successRespCode);
		return b;
	}
}

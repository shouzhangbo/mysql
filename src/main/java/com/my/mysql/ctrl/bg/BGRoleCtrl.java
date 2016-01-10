package com.my.mysql.ctrl.bg;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.mysql.constants.GlobalConstant;
import com.my.mysql.model.MgUser;
import com.my.mysql.model.Role;
import com.my.mysql.response.BaseResponse;
import com.my.mysql.response.RoleResponse;
import com.my.mysql.response.bean.MgUserBeans;
import com.my.mysql.response.bean.RoleBeans;
import com.my.mysql.service.RoleService;
import com.my.mysql.util.CommUtil;

@Controller
@RequestMapping(value = "/role")
public class BGRoleCtrl {

	@Autowired
	private RoleService roleService;
	@RequestMapping(value = "/test", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public String test(String test,HttpServletRequest request,HttpServletResponse response){
		System.out.println("test="+test);
		return "rr";
	}
	@RequestMapping(value = "/add", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
	public BaseResponse add(Role roleForm,HttpServletRequest request,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*" );
		try {
			response.setContentType("text/html;charset=utf-8");
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		BaseResponse b = new BaseResponse();
		Role role = new Role();
		System.out.println("roleForm.getRoleName()="+roleForm.getRoleName());
		role.setRoleName(roleForm.getRoleName());
		role.setStatus(GlobalConstant.okInt);
		role.setStatusName("上线");
		role.setCreateAt(new Date());
		role.setUpdateAt(new Date());
		roleService.save(role);
		
		b.setRespCode(GlobalConstant.successRespCode);
		return b;
	}
	@RequestMapping(value = "/query", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public RoleResponse query(Role roleForm,HttpServletRequest request,HttpServletResponse response){
		RoleResponse b = new RoleResponse();
		response.setHeader("Access-Control-Allow-Origin", "*" );
		List<RoleBeans> beanList = new ArrayList<RoleBeans>();
		List<Role> list = roleService.query(roleForm);
		System.out.println("list="+list.size());
		if(CommUtil.isEmpty(list)||list.size()<1){
			return b;
		}
		for(int i=0;i<list.size();i++){
			RoleBeans cb = new RoleBeans();
			BeanCopier copier = BeanCopier.create(Role.class, RoleBeans.class,
                    false);
            copier.copy(list.get(i), cb, null);
            beanList.add(cb);
		}
		b.setList(beanList);
		b.setRespCode(GlobalConstant.successRespCode);
		return b;
	}
}

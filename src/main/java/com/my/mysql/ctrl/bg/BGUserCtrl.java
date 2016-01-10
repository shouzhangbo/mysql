package com.my.mysql.ctrl.bg;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.mysql.constants.GlobalConstant;
import com.my.mysql.form.bg.UserForm;
import com.my.mysql.model.MgUser;
import com.my.mysql.model.Role;
import com.my.mysql.response.BaseResponse;
import com.my.mysql.response.MgUserResponse;
import com.my.mysql.response.bean.MgUserBeans;
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
	
	@RequestMapping(value = "add", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
	public BaseResponse add(UserForm userForm,HttpServletRequest request,HttpServletResponse response)
	{
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		response.setHeader("Access-Control-Allow-Origin", "*" );
		BaseResponse b = new BaseResponse();
		
		Role role = roleService.findById(Role.class, userForm.getRoleId());
		if(!CommUtil.isEmpty(role)){
			MgUser mgUser = new MgUser();
			mgUser.setMgUserName(userForm.getUserName());
			mgUser.setMgPsd(CommUtil.MD5(userForm.getUserPsd()));
			mgUser.setStatus(GlobalConstant.okInt);
			mgUser.setStatusName("上线");
			mgUser.setRole(role);
			mgUser.setCreateAt(new Date());
			mgUser.setUpdateAt(new Date());
			mgUserService.save(mgUser);
			b.setRespCode(GlobalConstant.successRespCode);
			return b;
		}
		return b;
	}
	
	@RequestMapping(value = "login", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
	public BaseResponse login(UserForm userForm,HttpServletRequest request,HttpServletResponse response)
	{
		response.setHeader("Access-Control-Allow-Origin", "*" );
		BaseResponse b = new BaseResponse();
		HttpSession session = request.getSession();
		List<MgUser> list = mgUserService.queryByUserName(userForm);
		if(CommUtil.isEmpty(list)||list.size()<1){
			return b;
		}
		session.setAttribute("bgUser", list.get(0));
		b.setRespCode(GlobalConstant.successRespCode);
		return b;
	}
	@RequestMapping(value = "quite", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
	public BaseResponse quite(UserForm userForm,HttpServletRequest request,HttpServletResponse response)
	{
		response.setHeader("Access-Control-Allow-Origin", "*" );
		BaseResponse b = new BaseResponse();
		HttpSession session = request.getSession();
		session.removeAttribute("bgUser");
		b.setRespCode(GlobalConstant.successRespCode);
		return b;
	}
	@RequestMapping(value = "query", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
	public MgUserResponse query(UserForm userForm,HttpServletRequest request,HttpServletResponse response)
	{
		response.setHeader("Access-Control-Allow-Origin", "*" );
		List<MgUserBeans> beanList = new ArrayList<MgUserBeans>();
		MgUserResponse b = new MgUserResponse();
		List<MgUser> list = mgUserService.queryByCond(userForm);
		if(CommUtil.isEmpty(list)||list.size()<1){
			return b;
		}
		for(int i=0;i<list.size();i++){
			MgUserBeans cb = new MgUserBeans();
			BeanCopier copier = BeanCopier.create(MgUser.class, MgUserBeans.class,
                    false);
            copier.copy(list.get(i), cb, null);
            if(!CommUtil.isEmpty(list.get(i).getRole())){
            	cb.setRoleName(list.get(i).getRole().getRoleName());
            }
            beanList.add(cb);
		}
		b.setList(beanList);
		b.setRespCode(GlobalConstant.successRespCode);
		return b;
	}
}

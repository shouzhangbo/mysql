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
import com.my.mysql.form.bg.UserForm;
import com.my.mysql.model.Menu;
import com.my.mysql.model.MgUser;
import com.my.mysql.model.Role;
import com.my.mysql.response.BaseResponse;
import com.my.mysql.response.MenuResponse;
import com.my.mysql.response.MgUserResponse;
import com.my.mysql.response.bean.MenuBeans;
import com.my.mysql.response.bean.MgUserBeans;
import com.my.mysql.service.MenuService;
import com.my.mysql.util.CommUtil;

@Controller
@RequestMapping(value = "/menu")
public class BGMenuCtrl {

	@Autowired
	private MenuService menuService;
	
	@RequestMapping(value = "add", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
	public BaseResponse add(Menu menuForm,HttpServletRequest request,HttpServletResponse response)
	{
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		response.setHeader("Access-Control-Allow-Origin", "*" );
		BaseResponse b = new BaseResponse();
		
		Menu menu = new Menu();
		menu.setMenuName(menuForm.getMenuName());
		menu.setIndexs(1);
		menu.setMenuIco("test");
		menu.setStatus(GlobalConstant.okInt);
		menu.setStatusName("上线");
		menu.setCreateAt(new Date());
		menu.setUpdateAt(new Date());
		
		menuService.save(menu);
		b.setRespCode(GlobalConstant.successRespCode);
		return b;
	}
	
	@RequestMapping(value = "query", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
	public MenuResponse query(Menu menuForm,HttpServletRequest request,HttpServletResponse response)
	{
		response.setHeader("Access-Control-Allow-Origin", "*" );
		List<MenuBeans> beanList = new ArrayList<MenuBeans>();
		MenuResponse b = new MenuResponse();
		List<Menu> list = menuService.query(menuForm);
		if(CommUtil.isEmpty(list)||list.size()<1){
			return b;
		}
		for(int i=0;i<list.size();i++){
			MenuBeans cb = new MenuBeans();
			BeanCopier copier = BeanCopier.create(Menu.class, MenuBeans.class,
                    false);
            copier.copy(list.get(i), cb, null);
            beanList.add(cb);
		}
		b.setList(beanList);
		b.setRespCode(GlobalConstant.successRespCode);
		return b;
	}
}

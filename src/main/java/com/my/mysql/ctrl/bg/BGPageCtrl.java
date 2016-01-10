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
import com.my.mysql.model.Menu;
import com.my.mysql.model.Page;
import com.my.mysql.model.Role;
import com.my.mysql.response.BaseResponse;
import com.my.mysql.response.PageResponse;
import com.my.mysql.response.RoleResponse;
import com.my.mysql.response.bean.PageBeans;
import com.my.mysql.response.bean.RoleBeans;
import com.my.mysql.service.MenuService;
import com.my.mysql.service.PageService;
import com.my.mysql.util.CommUtil;

@Controller
@RequestMapping(value = "/page")
public class BGPageCtrl {

	@Autowired
	private PageService pageService;
	@Autowired
	private MenuService menuService;
	
	@RequestMapping(value = "/add", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
	public BaseResponse add(Page pageForm,Integer menuId,HttpServletRequest request,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*" );
		BaseResponse b = new BaseResponse();
		try {
			response.setContentType("text/html;charset=utf-8");
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		Menu menu = menuService.findById(Menu.class, menuId);
		if(!CommUtil.isEmpty(menu)){
			Page page = new Page();
			page.setPageName(pageForm.getPageName());
			page.setIndexs(1);
			page.setPageIco(pageForm.getPageIco());
			page.setPageUrl(pageForm.getPageUrl());
			page.setStatus(GlobalConstant.okInt);
			page.setStatusName("上线");
			page.setCreateAt(new Date());
			page.setUpdateAt(new Date());
			
			page.setMenu(menu);
			pageService.save(page);
		}
		b.setRespCode(GlobalConstant.successRespCode);
		return b;
	}
	@RequestMapping(value = "/query", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public PageResponse query(Page pageForm,HttpServletRequest request,HttpServletResponse response){
		PageResponse b = new PageResponse();
		response.setHeader("Access-Control-Allow-Origin", "*" );
		List<PageBeans> beanList = new ArrayList<PageBeans>();
		List<Page> list = pageService.query(pageForm);
		if(CommUtil.isEmpty(list)||list.size()<1){
			return b;
		}
		for(int i=0;i<list.size();i++){
			PageBeans cb = new PageBeans();
			BeanCopier copier = BeanCopier.create(Page.class, PageBeans.class,
                    false);
            copier.copy(list.get(i), cb, null);
            beanList.add(cb);
		}
		b.setList(beanList);
		b.setRespCode(GlobalConstant.successRespCode);
		return b;
	}
}

package com.my.mysql.ctrl.bg;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.my.mysql.constants.GlobalConstant;
import com.my.mysql.form.AuthorityForm;
import com.my.mysql.model.Authority;
import com.my.mysql.model.Menu;
import com.my.mysql.model.Page;
import com.my.mysql.model.Role;
import com.my.mysql.model.view.AuthorityView;
import com.my.mysql.response.AuthorityResponse;
import com.my.mysql.response.BaseResponse;
import com.my.mysql.response.MenuResponse;
import com.my.mysql.response.RoleResponse;
import com.my.mysql.response.bean.AuthorityBeans;
import com.my.mysql.response.bean.MenuBeans;
import com.my.mysql.response.bean.PageBeans;
import com.my.mysql.response.bean.RoleBeans;
import com.my.mysql.service.AuthorityService;
import com.my.mysql.service.MenuService;
import com.my.mysql.service.PageService;
import com.my.mysql.service.RoleService;
import com.my.mysql.util.CommUtil;
import com.my.mysql.util.JsonUtil;

@Controller
@RequestMapping(value = "/authority")
public class BGAuthorityCtrl {

	@Autowired
	private AuthorityService authorityService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private PageService pageService;
	@Autowired
	private MenuService menuService;
	
	@RequestMapping(value = "add", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
	public BaseResponse add(AuthorityForm auForm,
			HttpServletRequest request,HttpServletResponse response)
	{
		response.setHeader("Access-Control-Allow-Origin", "*" );
		BaseResponse b = new BaseResponse();
		Role role = roleService.findById(Role.class, auForm.getRoleId());
		System.out.println("auFormArr="+auForm.getArr());
		if(!CommUtil.isEmpty(role)){
			Map<String, Object> map = JsonUtil.json2Map(auForm.getArr());
			JSONArray jsonArr = (JSONArray)map.get("list");
			for(int i=0;i<jsonArr.size();i++){
				JSONObject obj = (JSONObject) jsonArr.get(i);
				String id = obj.getString("pageId");
				if(!CommUtil.isEmpty(id)){
					Page page = pageService.findById(Page.class, Integer.parseInt(id));
					if(!CommUtil.isEmpty(page)){
						auForm.setPageId(Integer.parseInt(id));
						System.out.println("auForm="+auForm.getPageId()+",,role="+auForm.getRoleId());
						List<AuthorityView> auViewList = authorityService.queryByCond(auForm);
						System.out.println("auViewList="+auViewList.size());
						if(isEq(auViewList, auForm.getRoleId(), Integer.parseInt(id))){
							continue;
						}
//						if(!CommUtil.isEmpty(auViewList)&&auViewList.size()>0){
//							Authority au = authorityService.findById(Authority.class, auViewList.get(0).getAuthorityId());
//							if(!CommUtil.isEmpty(au)){
//								if(!CommUtil.isEmpty(au.getAuPage())&&!CommUtil.isEmpty(au.getAuRole())){
//									if(au.getAuPage().getPageId()==Integer.parseInt(id)&&au.getAuRole().getRoleId()==auForm.getRoleId())
//									{
//										continue;
//									}
//								}
//							}
//						}
							
						Authority au = new Authority();
						au.setAuPage(page);
						au.setAuRole(role);
						au.setCreateAt(new Date());
						au.setUpdateAt(new Date());
						authorityService.save(au);
					}
				}
			}
		}
		b.setRespCode(GlobalConstant.successRespCode);
		return b;
	}
	
	@RequestMapping(value = "query", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
	public AuthorityResponse query(Authority auForm,HttpServletRequest request,HttpServletResponse response)
	{
		response.setHeader("Access-Control-Allow-Origin", "*" );
		List<AuthorityBeans> beanList = new ArrayList<AuthorityBeans>();
		AuthorityResponse b = new AuthorityResponse();
		List<Authority> list = authorityService.query(auForm);
		if(CommUtil.isEmpty(list)||list.size()<1){
			return b;
		}
		for(int i=0;i<list.size();i++){
			AuthorityBeans cb = new AuthorityBeans();
			BeanCopier copier = BeanCopier.create(Authority.class, AuthorityBeans.class,
                    false);
            copier.copy(list.get(i), cb, null);
            cb.setPageName(list.get(i).getAuPage().getPageName());
            cb.setRoleName(list.get(i).getAuRole().getRoleName());
            beanList.add(cb);
		}
		b.setList(beanList);
		b.setRespCode(GlobalConstant.successRespCode);
		return b;
	}
	@RequestMapping(value = "queryByRole", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
	public MenuResponse queryByRole(AuthorityForm auForm,HttpServletRequest request,HttpServletResponse response){
		MenuResponse m = new MenuResponse();
		response.setHeader("Access-Control-Allow-Origin", "*" );
		if(CommUtil.isEmpty(auForm.getRoleId())){
			return m;
		}
		Set<Menu> menuSet = new HashSet<Menu>();
		Set<Page> pageSet = new HashSet<Page>();
		List<AuthorityView> list = authorityService.queryByCond(auForm);
		if(!CommUtil.isEmpty(list)&&list.size()>0){
			for(int i=0;i<list.size();i++){
				AuthorityView auView = list.get(i);
				if(!CommUtil.isEmpty(auView.getPageId())){
					Page page =pageService.findById(Page.class, auView.getPageId());
					if(!CommUtil.isEmpty(page)){
						Authority au = authorityService.findById(Authority.class, auView.getAuthorityId());
						if(au.getAuPage().getPageId()==page.getPageId()&&au.getAuRole().getRoleId()==auForm.getRoleId())
						{
							if(!CommUtil.isEmpty(page.getMenu())){
								pageSet.add(page);
								menuSet.add(page.getMenu());
							}
						}
					}
				}
			}
		}
		if(menuSet.size()<1){
			return m;
		}
		List<MenuBeans> beasList =  new ArrayList<MenuBeans>();
		int mount = 0;
		for(Menu menu:menuSet){
			MenuBeans cb = new MenuBeans();
			BeanCopier copier = BeanCopier.create(Menu.class, MenuBeans.class,
                    false);
            copier.copy(menu, cb, null);
            List<PageBeans> pageList = new ArrayList<PageBeans>();
            if(!CommUtil.isEmpty(menu.getPage())&&menu.getPage().size()>0)
            {
            	for(Page page:menu.getPage()){
            		if(isHas(pageSet,page.getPageId())){
	            		PageBeans pageBeans = new PageBeans();
	            		BeanCopier pageCopier = BeanCopier.create(Page.class, PageBeans.class,
	                            false);
	            		pageCopier.copy(page, pageBeans, null);
	            		pageList.add(pageBeans);
            		}
            	}
            	mount = mount + menu.getPage().size();
            }
            cb.setPageList(pageList);
            beasList.add(cb);
		}
		m.setTotalReco(mount);
		m.setList(beasList);
		m.setRespCode(GlobalConstant.successRespCode);
		return m;
	}
	@RequestMapping(value = "queryAll", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
	public MenuResponse queryAll(HttpServletRequest request,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*" );
		MenuResponse m = new MenuResponse();
		List<MenuBeans> beasList =  new ArrayList<MenuBeans>();
		Menu menuFor = new Menu();
		List<Menu> menuList = menuService.query(menuFor);
		if(CommUtil.isEmpty(menuList)||menuList.size()<1){
			return m;
		}
		int mount = 0;
		for(int i=0;i<menuList.size();i++){
			MenuBeans cb = new MenuBeans();
			BeanCopier copier = BeanCopier.create(Menu.class, MenuBeans.class,
                    false);
            copier.copy(menuList.get(i), cb, null);
            List<PageBeans> pageList = new ArrayList<PageBeans>();
            if(!CommUtil.isEmpty(menuList.get(i).getPage())&&menuList.get(i).getPage().size()>0)
            {
            	for(Page page:menuList.get(i).getPage()){
            		PageBeans pageBeans = new PageBeans();
            		BeanCopier pageCopier = BeanCopier.create(Page.class, PageBeans.class,
                            false);
            		pageCopier.copy(page, pageBeans, null);
            		pageList.add(pageBeans);
            	}
            	mount = mount + menuList.get(i).getPage().size();
            }
            cb.setPageList(pageList);
            beasList.add(cb);
		}
		m.setTotalReco(mount);
		m.setList(beasList);
		m.setRespCode(GlobalConstant.successRespCode);
		return m;
	}
	@RequestMapping(value = "queryRoleList", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public RoleResponse queryRoleList(HttpServletRequest request,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*" );
		RoleResponse r = new RoleResponse();
		List<RoleBeans> roleBeanList = new ArrayList<RoleBeans>();
		List<Role> roleList = roleService.query(new Role());
		if(!CommUtil.isEmpty(roleList)&&roleList.size()>0){
			for(Role role : roleList){
				RoleBeans roleBeans = new RoleBeans();
        		BeanCopier roleCopier = BeanCopier.create(Role.class, RoleBeans.class,
                        false);
        		roleCopier.copy(role, roleBeans, null);
        		List<PageBeans> pageBeanList = new ArrayList<PageBeans>();
        		List<MenuBeans> menuBeanList = new ArrayList<MenuBeans>();
        		for(Authority aut:role.getAuthority()){
        			int k = queryByMenu(menuBeanList, aut.getAuPage());
        			if(k>-1)
        			{
        				//已经存在
        				MenuBeans mBean = menuBeanList.get(k);
        				
        				PageBeans pageBeans = new PageBeans();
            			BeanCopier pageCopier = BeanCopier.create(Page.class, PageBeans.class,
                                false);
            			pageCopier.copy(aut.getAuPage(), pageBeans, null);
            			mBean.getPageList().add(pageBeans);
        				mBean.setPageList(mBean.getPageList());
        				mBean.setPageList(mBean.getPageList());
        				menuBeanList.set(k, mBean);
        			}else{
        				MenuBeans menuBeans = new MenuBeans();
            			
            			BeanCopier menuCopier = BeanCopier.create(Menu.class, MenuBeans.class,
                                false);
            			menuCopier.copy(aut.getAuPage().getMenu(), menuBeans, null);
            			
            			PageBeans pageBeans = new PageBeans();
            			BeanCopier pageCopier = BeanCopier.create(Page.class, PageBeans.class,
                                false);
            			pageCopier.copy(aut.getAuPage(), pageBeans, null);
            			pageBeanList.add(pageBeans);
            			menuBeans.setPageList(pageBeanList);
            			
            			menuBeanList.add(menuBeans);
        			}
        		}
        		roleBeans.setList(menuBeanList);
        		roleBeanList.add(roleBeans);
			}
		}
		r.setList(roleBeanList);
		r.setRespCode(GlobalConstant.successRespCode);
		return r;
	}
	
	
	public int queryByMenu(List<MenuBeans> menuBeanList,Page page){
		if(CommUtil.isEmpty(menuBeanList)||CommUtil.isEmpty(page)||CommUtil.isEmpty(page.getMenu()))
		{
			return -1;
		}
		for(int i=0;i<menuBeanList.size();i++){
			if(menuBeanList.get(i).getMenuId()==page.getMenu().getMenuId()){
				return i;
			}
		}
		return -1;
	}
	public boolean isEq(List<AuthorityView> auViewList,Integer roleId,Integer pageId){
		if(!CommUtil.isEmpty(auViewList)&&auViewList.size()>0){
			for(AuthorityView au : auViewList){
				Authority authority = authorityService.findById(Authority.class, au.getAuthorityId());
				if(!CommUtil.isEmpty(authority)&&!CommUtil.isEmpty(authority.getAuPage())&&!CommUtil.isEmpty(authority.getAuRole()))
				{
					if(pageId==authority.getAuPage().getPageId()&&roleId==authority.getAuRole().getRoleId())
					{
						return true;
					}
				}
			}
		}
		return false;
	}
	public boolean isHas(Set<Page> set,Integer pageId){
		for(Page page:set){
			if(pageId==page.getPageId()){
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("11111");
		list.add("22222");
		list.add("33333");
		for(String s:list){
			System.out.println("s=="+s);
		}
		for(int i=0;i<list.size();i++){
			if(i==1){
				list.set(i, "这里是测试的啊啊啊啊啊啊啊啊啊");
			}
		}
		for(String s:list){
			System.out.println("s=="+s);
		}
	}
}

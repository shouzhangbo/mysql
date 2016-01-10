package com.my.mysql.service.impl;

import java.util.*;

import org.springframework.stereotype.Service;

import com.my.mysql.form.bg.UserForm;
import com.my.mysql.model.MgUser;
import com.my.mysql.service.MgUserService;
import com.my.mysql.util.CommUtil;
import com.my.mysql.util.PageInfo;

@Service
public class MgUserServiceImpl extends BaseServiceImpl<MgUser> implements MgUserService{

	@Override
	public List<MgUser> queryByUserName(UserForm userForm) {
		List<MgUser> list = new ArrayList<MgUser>();
		String hql = "from MgUser where mgUserName=:mgUserName and mgPsd=:mgPsd";
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("mgUserName", userForm.getUserName());
		map.put("mgPsd", userForm.getUserPsd());
		list = baseDao.find(hql, map);
		return list;
	}

	@Override
	public List<MgUser> queryByCond(UserForm userForm) {
		List<MgUser> list = new ArrayList<MgUser>();
		String hql = "from MgUser where 1=1";
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			if(!CommUtil.isEmpty(userForm.getUserName())){
				hql = hql + " and mgUserName like :mgUserName ";
				map.put("mgUserName", userForm.getUserName());
			}
			if(!CommUtil.isEmpty(userForm.getStartTime())){
				hql = hql + " and createAt >=:createAt";
				map.put("createAt", sdf.parse(userForm.getStartTime()));
			}
			if(!CommUtil.isEmpty(userForm.getEndTime())){
				hql = hql + " and createAt <=:createAt";
				map.put("createAt", sdf.parse(userForm.getEndTime()));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		PageInfo pageInfo = new PageInfo();
		if(CommUtil.isEmpty(userForm.getPageSize())||0==userForm.getPageSize()){
			pageInfo.setPageSize(5);
		}else{
			pageInfo.setPageSize(userForm.getPageSize());
		}
		if(CommUtil.isEmpty(userForm.getCurrentPage())||0==userForm.getCurrentPage()){
			pageInfo.setCurrentPage(1);
		}else{
			pageInfo.setCurrentPage(userForm.getCurrentPage());
		}
		list = baseDao.findByPage(hql, map,pageInfo);
		return list;
	}

}

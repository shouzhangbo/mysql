package com.my.mysql.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.my.mysql.form.AuthorityForm;
import com.my.mysql.model.Authority;
import com.my.mysql.model.view.AuthorityView;
import com.my.mysql.service.AuthorityService;
import com.my.mysql.util.CommUtil;

@Service
public class AuthorityServiceImpl extends BaseServiceImpl<Authority> implements AuthorityService{

	@Override
	public List<Authority> query(Authority auForm) {
		List<Authority> list = new ArrayList<Authority>();
		String hql = "from Authority where 1=1";
		Map<String,Object> map = new HashMap<String,Object>();
		list = baseDao.find(hql, map);
		return list;
	}

	@Override
	public List<AuthorityView> queryByCond(AuthorityForm auForm) {
		List<AuthorityView> list = new ArrayList<AuthorityView>();
		StringBuilder hqlStr = new StringBuilder("select new com.my.mysql.model.view.AuthorityView");
		hqlStr.append(" (r.roleId as roleId,r.roleName as roleName,r.status as roleStatus,r.statusName as roleStatusName,");
		hqlStr.append("a.authorityId as authorityId,a.createAt as createAt,a.updateAt as updateAt,p.pageId as pageId,");
		hqlStr.append("p.pageName as pageName,p.pageIco as pageIco,p.pageUrl as pageUrl,p.indexs as indexs,p.status as status,");
		hqlStr.append("p.statusName as statusName)");
		hqlStr.append(" from Authority a,Role r,Page p where 1=1 ");
		if(!CommUtil.isEmpty(auForm.getAuthorityId())){
			hqlStr.append(" and a.authorityId="+auForm.getAuthorityId());
		}
		if(!CommUtil.isEmpty(auForm.getPageId())){
			hqlStr.append(" and p.pageId="+auForm.getPageId());
		}
		if(!CommUtil.isEmpty(auForm.getRoleId())){
			hqlStr.append(" and r.roleId="+auForm.getRoleId());
		}
		System.out.println("hqlStr="+hqlStr.toString());
		list = baseDao.findModelView(hqlStr.toString());
		return list;
	}

}

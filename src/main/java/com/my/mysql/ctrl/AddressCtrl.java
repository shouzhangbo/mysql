package com.my.mysql.ctrl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.mysql.constants.GlobalConstant;
import com.my.mysql.model.Address;
import com.my.mysql.model.BaseUser;
import com.my.mysql.model.Category;
import com.my.mysql.response.AddressResponse;
import com.my.mysql.response.BaseResponse;
import com.my.mysql.response.bean.AddressBeans;
import com.my.mysql.response.bean.CategoryBeans;
import com.my.mysql.service.AddressService;
import com.my.mysql.service.BaseUserService;
import com.my.mysql.util.CommUtil;

import net.sf.cglib.beans.BeanCopier;

@Controller
@RequestMapping(value = "/address")
public class AddressCtrl {

	@Autowired
	private BaseUserService baseUserService;
	@Autowired
	private AddressService addressService;
	
	@RequestMapping(value = "add", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
	public BaseResponse add(String userName,Address addressForm,
			HttpServletRequest request,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*" );
		BaseResponse b = new BaseResponse();
		HttpSession session = request.getSession();
		BaseUser user = (BaseUser) session.getAttribute(userName);
		if(CommUtil.isEmpty(user)){
			b.setRespCode("1000");
//			return b;
		}
		List<BaseUser> userList = baseUserService.findByProperty(BaseUser.class, "userName", userName);
		if(!CommUtil.isEmpty(userList)&&userList.size()>0){
			Address address = new Address();
			address.setAddressInfo(addressForm.getAddressInfo());
			address.setAddressStreet(addressForm.getAddressStreet());
			address.setAddresUser(userList.get(0));
			address.setReceiveMan(addressForm.getReceiveMan());
			address.setReceivePhone(addressForm.getReceivePhone());
			address.setCreateAt(new Date());
			address.setUpdateAt(new Date());
			
			addressService.save(address);
		}
		b.setRespCode(GlobalConstant.successRespCode);
		return b;
	}
	@RequestMapping(value = "query", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
	public AddressResponse query(String userName,HttpServletRequest request,HttpServletResponse response){
		AddressResponse b = new AddressResponse();
		response.setHeader("Access-Control-Allow-Origin", "*" );
		HttpSession session = request.getSession();
		BaseUser user = (BaseUser) session.getAttribute(userName);
		if(CommUtil.isEmpty(user)){
			b.setRespCode("1000");
//			return b;
		}
		List<AddressBeans> beanList = new ArrayList<AddressBeans>();
		List<BaseUser> userList = baseUserService.findByProperty(BaseUser.class, "userName", userName);
		if(!CommUtil.isEmpty(userList)&&userList.size()>0){
			Set<Address> addressList = userList.get(0).getAddress();
			if(!CommUtil.isEmpty(addressList)&&addressList.size()>0){
				for(Address a:addressList){
					AddressBeans bean = new AddressBeans();
					BeanCopier copier = BeanCopier.create(Address.class, AddressBeans.class,
		                    false);
		            copier.copy(a, bean, null);
		            beanList.add(bean);
				}
			}
		}
		b.setList(beanList);
		b.setRespCode(GlobalConstant.successRespCode);
		return b;
	}
}

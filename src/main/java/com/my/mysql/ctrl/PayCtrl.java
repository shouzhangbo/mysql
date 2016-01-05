package com.my.mysql.ctrl;

import java.util.HashSet;
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
import com.my.mysql.model.BaseUser;
import com.my.mysql.model.OrderInfo;
import com.my.mysql.response.BaseResponse;
import com.my.mysql.service.AddressService;
import com.my.mysql.service.BaseUserService;
import com.my.mysql.service.OrderInfoService;
import com.my.mysql.service.OrderService;
import com.my.mysql.service.ProductService;

@Controller
@RequestMapping(value ="pay")
public class PayCtrl {

	@Autowired
	private OrderService orderService;
	@Autowired
	private OrderInfoService orderInfoService;
	@Autowired
	private ProductService productService;
	@Autowired
	private BaseUserService baseUserService;
	@Autowired
	private AddressService addressService;
	@RequestMapping(value = "/pay", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
	public BaseResponse pay(String userName,
			HttpServletRequest request,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*" );
		BaseResponse b = new BaseResponse();
		HttpSession session = request.getSession();
		Set<OrderInfo> set = new HashSet<OrderInfo>();
		int countPrice = 0;
		BaseUser user = (BaseUser) session.getAttribute(userName);
//		if(CommUtil.isEmpty(user)){
//			b.setRespCode("1000");
//			return b;
//		}
		b.setRespCode(GlobalConstant.successRespCode);
		return b;
	}
	
}

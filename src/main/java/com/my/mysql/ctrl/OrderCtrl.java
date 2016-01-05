package com.my.mysql.ctrl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
import com.my.mysql.form.OrderForm;
import com.my.mysql.model.Address;
import com.my.mysql.model.BaseUser;
import com.my.mysql.model.Order;
import com.my.mysql.model.OrderInfo;
import com.my.mysql.model.Product;
import com.my.mysql.response.BaseResponse;
import com.my.mysql.service.AddressService;
import com.my.mysql.service.BaseUserService;
import com.my.mysql.service.OrderInfoService;
import com.my.mysql.service.OrderService;
import com.my.mysql.service.ProductService;
import com.my.mysql.util.CommUtil;
import com.my.mysql.util.JsonUtil;
import com.my.mysql.util.RedisUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping(value ="order")
public class OrderCtrl {

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
	
	@RequestMapping(value = "/add", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
	public BaseResponse add(String userName,String list,Integer addressId,
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
		List<BaseUser> userList = baseUserService.findByProperty(BaseUser.class, "userName", userName);
		if(CommUtil.isEmpty(userList)||userList.size()<1){
			b.setRespMsg("该用户不存在");
			return b;
		}
		Address address = addressService.findById(Address.class, addressId);
		if(CommUtil.isEmpty(address)){
			b.setRespMsg("该地址不存在");
			return b;
		}
		System.out.println("list======"+list);
		if(!CommUtil.isEmpty(list)){
			Map<String, Object> map = JsonUtil.json2Map(list);
			JSONArray arr = (JSONArray)map.get("list");
			for(int i=0;i<arr.size();i++){
				OrderInfo orderInfo = new OrderInfo();
				JSONObject obj = (JSONObject)arr.get(i);
				Product pro = productService.findById(Product.class, Integer.parseInt(obj.getString("productId")));
				if(CommUtil.isEmpty(pro)){
					b.setRespMsg("该商品不存在");
					return b;
				}
				orderInfo.setProduct(pro);
				orderInfo.setCount(Integer.parseInt(obj.getString("count")));
				orderInfo.setOrderInfoNo(getOrderInfoNo());
				orderInfo.setOrderInfoPrice(pro.getPrice());
				orderInfo.setStatus(GlobalConstant.okInt);
				orderInfo.setStatusName("下单成功");
				orderInfo.setCreateAt(new Date());
				orderInfo.setUpdateAt(new Date());
				countPrice = countPrice + pro.getPrice();
				Object orderInfoObj = orderInfoService.save(orderInfo);
				OrderInfo oInfo = orderInfoService.findById(OrderInfo.class, Integer.parseInt(orderInfoObj.toString()));
				set.add(oInfo);
				//删除redis里面的商品
				RedisUtil redis = new RedisUtil();
				List<String> redisList = redis.queryListAll(userName);
				if(!CommUtil.isEmpty(list)){
					for(int j=0;j<redisList.size();j++){
						Map<String,String> getMap = CommUtil.getMapByStr(redisList.get(j));
						if(getMap.get("productId").equals(""+obj.getString("productId"))){
							redis.delete(userName,redisList.get(j));
						}
					}
				}
			}
		}
		Order order = new Order();
		order.setBaseUser(userList.get(0));
		order.setAddress(address);
		order.setOrderInfo(set);
		order.setOrderPrice(countPrice);
		order.setOrderNo("order"+getOrderInfoNo());
		order.setStatus(GlobalConstant.okInt);
		order.setStatusName("下单成功");
		order.setCreateAt(new Date());
		order.setUpdateAt(new Date());
		Object orderObj = orderService.save(order);
		
		Order order1 = orderService.findById(Order.class,Integer.parseInt(orderObj.toString()));
		if(!CommUtil.isEmpty(order1)){
			for(OrderInfo oInfo:set){
				oInfo.setOrder(order1);
			}
		}
		b.setRespCode(GlobalConstant.successRespCode);
		return b;
	}
	@RequestMapping(value = "/query", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
	public OrderResponse query(OrderForm orderForm,
			HttpServletRequest request,HttpServletResponse response){
		OrderResponse b = new OrderResponse();
		
		return b;
	}
	
	public String getOrderInfoNo(){
		return new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
	}
}

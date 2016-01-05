package com.my.mysql.ctrl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.my.mysql.model.Product;
import com.my.mysql.response.BaseResponse;
import com.my.mysql.response.ShopCarResponse;
import com.my.mysql.response.bean.ProductBean;
import com.my.mysql.service.BaseUserService;
import com.my.mysql.service.ProductService;
import com.my.mysql.util.CommUtil;
import com.my.mysql.util.RedisUtil;

@Controller
@RequestMapping(value ="redis")
public class ShopCarCtrl {

	@Autowired
	private ProductService productService;
	@Autowired
	private BaseUserService baseUserService;
	
	@RequestMapping(value = "/add", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
	public BaseResponse add(String userId,Integer productId,Integer num,HttpServletRequest request,HttpServletResponse response)
	{
		response.setHeader("Access-Control-Allow-Origin", "*" );
		BaseResponse b = new BaseResponse();
		HttpSession session = request.getSession();
		BaseUser user = (BaseUser) session.getAttribute(userId);
		if(CommUtil.isEmpty(user)){
			b.setRespCode("1000");
			return b;
		}
		List<BaseUser> baseUserList = baseUserService.findByProperty(BaseUser.class, "userName", userId);
		if(CommUtil.isEmpty(baseUserList)||baseUserList.size()<1){
			b.setRespMsg("该用户不存在");
			return b;
		}
		RedisUtil redis = new RedisUtil();
		//先判断商品是否存在
		Product pro = productService.findById(Product.class, productId);
		if(CommUtil.isEmpty(pro)){
			b.setRespMsg("该商品不存在");
			return b;
		}else if(pro.getNowNum()<num){
			b.setRespMsg("商品剩余数量不足");
			return b;
		}
		List<String> list = redis.queryListAll(userId);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("productId", productId);
		
		if(!CommUtil.isEmpty(list)){
			for(int i=0;i<list.size();i++){
				Map<String,String> getMap = CommUtil.getMapByStr(list.get(i));
				if(getMap.get("productId").equals(""+productId)){
					map.put("num", getMap.get("num")+num);
					redis.update(userId,i+1,map.toString());
					break;
				}
			}
			map.put("num", num);
			redis.addList(userId,map.toString());
			b.setRespCode(GlobalConstant.successRespCode);
			return b;
		}else{
			map.put("num", num);
			redis.addList(userId,map.toString());
			b.setRespCode(GlobalConstant.successRespCode);
			return b;
		}
	}
	@RequestMapping(value = "/delete", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
	public BaseResponse delete(String userId,Integer productId,Integer num,
			HttpServletRequest request,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*" );
		BaseResponse b = new BaseResponse();
		HttpSession session = request.getSession();
		BaseUser user = (BaseUser) session.getAttribute(userId);
		if(CommUtil.isEmpty(user)){
			b.setRespCode("1000");
			return b;
		}
		RedisUtil redis = new RedisUtil();
		List<String> list = redis.queryListAll(userId);
		if(!CommUtil.isEmpty(list)){
			for(int i=0;i<list.size();i++){
				Map<String,String> getMap = CommUtil.getMapByStr(list.get(i));
				if(getMap.get("productId").equals(""+productId)){
					redis.delete(userId,list.get(i));
					b.setRespCode(GlobalConstant.successRespCode);
					return b;
				}
			}
		}
		return b;
	}
	@RequestMapping(value = "/query", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
	public ShopCarResponse query(String userId,HttpServletRequest request,HttpServletResponse response)
	{
		response.setHeader("Access-Control-Allow-Origin", "*" );
		ShopCarResponse b = new ShopCarResponse();
		HttpSession session = request.getSession();
		BaseUser user = (BaseUser) session.getAttribute(userId);
		if(CommUtil.isEmpty(user)){
			b.setRespCode("1000");
		}
		RedisUtil redis = new RedisUtil();
		List<String> list = redis.queryListAll(userId);
		List<ProductBean> beanList = new ArrayList<ProductBean>();
		if(!CommUtil.isEmpty(list)&&list.size()>0){
			for(int i=0;i<list.size();i++){
				Map<String,String> getMap = CommUtil.getMapByStr(list.get(i));
				List<Product> pro = productService.findByProperty(Product.class,"productId", Integer.parseInt(getMap.get("productId")));
				if(!CommUtil.isEmpty(pro)){
					Map<String,Object> bean = new HashMap<String,Object>();
					ProductBean bean1 = new ProductBean(pro.get(0),Integer.parseInt(getMap.get("num")));    
					beanList.add(bean1);
				}
			}
		}
		b.setList(beanList);
		b.setRespCode(GlobalConstant.successRespCode);
		return b;
	}
	
	public static void main(String[] args) {
		String str = "{num=2, productId=1},{num=2, productId=1}";
		System.out.println(CommUtil.getMapByStr(str));
	}
}

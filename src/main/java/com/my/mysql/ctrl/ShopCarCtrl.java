package com.my.mysql.ctrl;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.mysql.response.BaseResponse;
import com.my.mysql.util.CommUtil;
import com.my.mysql.util.RedisUtil;

@Controller
public class ShopCarCtrl {

	@RequestMapping(value = "/add", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
	public BaseResponse add(String userId,String pro){
		BaseResponse b = new BaseResponse();
		RedisUtil redis = new RedisUtil();
		List<String> list = redis.queryListAll(userId);
		if(!CommUtil.isEmpty(list)){
			for(int i=0;i<list.size();i++){
				if(true){
					redis.update(userId,i,pro);
					break;
				}
			}
			redis.addList(userId,pro);
		}
		return b;
	}
	@RequestMapping(value = "/delete", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
	public BaseResponse delete(String userId,String pro){
		BaseResponse b = new BaseResponse();
		RedisUtil redis = new RedisUtil();
		List<String> list = redis.queryListAll(userId);
		if(!CommUtil.isEmpty(list)){
			for(int i=0;i<list.size();i++){
				if(true){
					redis.delete(userId,list.get(i));
					break;
				}
			}
		}
		return b;
	}
	@RequestMapping(value = "/query", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
	public BaseResponse query(String userId){
		BaseResponse b = new BaseResponse();
		RedisUtil redis = new RedisUtil();
		List<String> list = redis.queryListAll(userId);
		return b;
	}
}

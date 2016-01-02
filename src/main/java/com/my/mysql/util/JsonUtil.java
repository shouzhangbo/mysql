package com.my.mysql.util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({ "unchecked" })
public class JsonUtil {

	protected final static Logger logger = LoggerFactory
			.getLogger(JsonUtil.class);
	private static ObjectMapper objectMapper = new ObjectMapper();

	/**
	 * 
	 * JSON,使用Jackson转换Java对象.
	 * 
	 */
	public static <X> X renderObject(String json, Class<X> clazz) {
		try {
			return objectMapper.readValue(json, clazz);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		return null;
	}

	public static <X> X renderMap(Map<String,Object> map, Class<X> clazz) {
		try {
			return objectMapper.readValue(
					objectMapper.writeValueAsString(map), clazz);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		return null;
	}

	public static Map<String, Object> json2Map(String jsonStr) {
		JSONObject json = JSONObject.fromObject(jsonStr);
		Map<String, Object> map = new HashMap<String, Object>();
		Iterator<String> it = json.keys();
		while (it.hasNext()) {
			String key = it.next();
			map.put(key, json.get(key));
		}
		return map;
	}

	public static String objct2Json(Object object) {
		try {
			return objectMapper.writeValueAsString(object);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			e.printStackTrace();
		}
		return "";
	}

	public static Map<String, Object> mapFromJsonArray(String JsonArray) {
		try {
			JSONArray error_ = JSONArray.fromObject(JsonArray);
			Map<String, Object> err_map = JsonUtil
					.json2Map(error_.getString(0));
			return err_map;
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) {
		String str = "{\"houzhangbo\":[{\"hozuhangbo\":1,\"count\":12}]}";
		System.out.println(str);
		Map<String, Object> map = json2Map(str);
		System.out.println(map.get("houzhangbo"));
		JSONArray arr = (JSONArray)map.get("houzhangbo");
		for(int i=0;i<arr.size();i++){
			JSONObject obj = (JSONObject)arr.get(i);
		}
	}
}
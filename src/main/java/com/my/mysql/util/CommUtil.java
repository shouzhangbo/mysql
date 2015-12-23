package com.my.mysql.util;

import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CommUtil {

	public static boolean isEmpty(Object obj){
		if(obj==null){
			return true;
		}
		if("".equals(obj.toString().trim())){
			return true;
		}
		if("null".equals(obj.toString().trim())){
			return true;
		}
		return false;
	}
	
	public static String MD5(String s){
		char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		 try {
	            byte[] btInput = s.getBytes();
	            // 获得MD5摘要算法的 MessageDigest 对象
	            MessageDigest mdInst = MessageDigest.getInstance("MD5");
	            // 使用指定的字节更新摘要
	            mdInst.update(btInput);
	            // 获得密文
	            byte[] md = mdInst.digest();
	            // 把密文转换成十六进制的字符串形式
	            int j = md.length;
	            char str[] = new char[j * 2];
	            int k = 0;
	            for (int i = 0; i < j; i++) {
	                byte byte0 = md[i];
	                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
	                str[k++] = hexDigits[byte0 & 0xf];
	            }
	            return new String(str);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	}
	
	public static Map<String,String> getMapByStr(String str){
		Map<String,String> map = new HashMap<String,String>();
		if(!str.startsWith("{")||!str.endsWith("}")||str.indexOf("=")<0){
			return null;
		}
		//只有一个
		if(getInt("{")<1){
			map.put(str.substring(str.indexOf("{")+1 , str.indexOf("=")), str.substring(str.indexOf("=") +1,str.indexOf(",")));
			str = str.substring(str.indexOf(",")+1, str.length()-1).trim();
			map.put(str.substring(0 , str.indexOf("=")), str.substring(str.indexOf("=") +1,str.length()));
		}else{
			str = str.substring(1, str.length()-1);
			while(getInt(str)>0){
				map.put(str.substring(0, str.indexOf("=")).trim(),str.substring(str.indexOf("=")+1,str.indexOf(",")).trim());
				str = str.substring(str.indexOf(",")+1, str.length()-1).trim();
			}
			if(str.indexOf("=")>0){
				map.put(str.substring(0, str.indexOf("=")).trim(),str.substring(str.indexOf("=")+1,str.length()).trim());
			}
		}
		return map;
	}
	public static int getInt(String str){
		int count = 0;
		for(int i=0;i<str.toCharArray().length;i++){
			if(','==str.toCharArray()[i]){
				count++;
			}
		}
		return count;
	}
	public static void main(String[] args) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("test1","test");
		map.put("test2","test1111");
		map.put("test3","test12342t34w111");
		map.put("test4","test11234211");
		System.out.println(map);
		System.out.println(map.get("test2"));
		Map<String,String> map1 = (Map<String,String>)getMapByStr(map.toString());
		System.out.println(map1);
		System.out.println(map1.size());
		Iterator it = map1.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry entry = (Map.Entry) it.next();
		    Object key = entry.getKey();
		    Object value = entry.getValue();
		    System.out.println("key=" + key + " value=" + value);
		}
		System.out.println(map1.get("test2"));
	}
}

package com.my.mysql.test;

import redis.clients.jedis.Jedis;

public class RedisTest {

	private Jedis jedis = null;  
    private String key1 = "key1";  
    private String key2 = "key2";  
  
    public RedisTest() {  
        jedis = new Jedis("localhost");  
    }  
    public void testData() {  
        jedis.set("key1", "data1");  
  
        System.out.println("Check status of data existing:"  
                + jedis.exists(key1));  
        System.out.println("Get Data key1:" + jedis.get("key1"));  
  
        long s = jedis.sadd(key2, "data2");  
        System.out.println("Add key2 Data:" + jedis.scard(key2)  
                + " with status " + s);  
    }
    public static void main(String[] args) {  
        RedisTest redisTest = new RedisTest();  
//        redisTest.isReachable();  
        redisTest.testData();  
//        redisTest.delData();  
//        redisTest.testExpire();  
    }
}

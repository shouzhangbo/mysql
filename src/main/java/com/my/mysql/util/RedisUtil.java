package com.my.mysql.util;

import java.util.ArrayList;
import java.util.List;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

public class RedisUtil {

//	http://www.open-open.com/lib/view/open1385173126448.html redis  api介绍
//	http://www.cnblogs.com/edisonfeng/p/3571870.html
	
	private Jedis jedis;//非切片额客户端连接
    private JedisPool jedisPool;//非切片连接池
	private ShardedJedis shardedJedis;//切片额客户端连接
    private ShardedJedisPool shardedJedisPool;//切片连接池
    
    public RedisUtil() 
    { 
        initialPool(); 
        initialShardedPool(); 
        shardedJedis = shardedJedisPool.getResource(); 
        jedis = jedisPool.getResource(); 
    } 
 
    /**
     * 初始化非切片池
     */
    private void initialPool() 
    { 
        // 池基本配置 
        JedisPoolConfig config = new JedisPoolConfig(); 
        config.setMaxActive(20); 
        config.setMaxIdle(5); 
        config.setMaxWait(1000l); 
        config.setTestOnBorrow(false); 
        jedisPool = new JedisPool(config,"127.0.0.1",6379);
    }
    
    /** 
     * 初始化切片池 
     */ 
    private void initialShardedPool() 
    { 
        // 池基本配置 
        JedisPoolConfig config = new JedisPoolConfig(); 
        config.setMaxActive(20); 
        config.setMaxIdle(5); 
        config.setMaxWait(1000l); 
        config.setTestOnBorrow(false); 
        // slave链接 
        List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>(); 
        shards.add(new JedisShardInfo("127.0.0.1", 6379, "master")); 
        // 构造池 
        shardedJedisPool = new ShardedJedisPool(config, shards); 
    } 
    /**
     * 判断key是否存在
     * @param key
     * @return
     */
    public boolean isKeyExt(String key){
    	 return shardedJedis.exists(key);
    }
   
    //String
    //List
    public void addList(String key,String value){
    	shardedJedis.lpush(key, value);
    }
    public List<String> queryListAll(String key){
    	if(!shardedJedis.exists(key)){
    		return null;
    	}
    	return  shardedJedis.lrange(key, 0, -1);
    }
    public void update(String key,int index,String value){
    	shardedJedis.lset(key, index, value);
    }
    public void delete(String key,String value){
    	shardedJedis.lrem(key, 0, value);
    }
    
    //Set
    //Map
    public void show(String key,int index,String value){
        shardedJedis.lset(key, index, value);
    }
    public static void main(String[] args) {
    	RedisUtil redist = new RedisUtil();
//    	redist.addList("userId", "test1");
//    	redist.show("10000",2,"111111111");
    	List<String> list = redist.queryListAll("10000");
    	for(int i=0;i<list.size();i++){
//    		if(i==0){
    			redist.update("10000",i,"test The Update");
//    		}
    		System.out.println("第"+i+"个:"+list.get(i));
    	}
    	System.out.println("******");
	}
}

package com.my.mysql.test;
import java.util.*;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;
import redis.clients.jedis.SortingParams;

public class RedisClient {

	private Jedis jedis;//非切片额客户端连接
    private JedisPool jedisPool;//非切片连接池
    private ShardedJedis shardedJedis;//切片额客户端连接
    private ShardedJedisPool shardedJedisPool;//切片连接池
    
    public RedisClient() 
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
    private void ListOperate() 
    { 
//        System.out.println("======================list=========================="); 
        // 清空数据 
//        System.out.println("清空库中所有数据："+jedis.flushDB()); 

//        System.out.println("=============增=============");
//        shardedJedis.lpush("stringlists", "vector"); 
//        shardedJedis.lpush("stringlists", "ArrayList"); 
//        shardedJedis.lpush("stringlists", "vector");
//        shardedJedis.lpush("stringlists", "vector");
//        shardedJedis.lpush("stringlists", "LinkedList");
//        shardedJedis.lpush("stringlists", "MapList");
//        shardedJedis.lpush("stringlists", "SerialList");
//        shardedJedis.lpush("stringlists", "HashList");
//        shardedJedis.lpush("numberlists", "3");
//        shardedJedis.lpush("numberlists", "1");
//        shardedJedis.lpush("numberlists", "5");
//        shardedJedis.lpush("numberlists", "2");
    	List list = shardedJedis.lrange("stringlists", 0, -1);
    	System.out.println(list.size());
        System.out.println("所有元素-stringlists："+shardedJedis.lrange("stringlists", 0, -1));
//        System.out.println("所有元素-numberlists："+shardedJedis.lrange("numberlists", 0, -1));
        
//        System.out.println("=============删=============");
//        // 删除列表指定的值 ，第二个参数为删除的个数（有重复时），后add进去的值先被删，类似于出栈
//        System.out.println("成功删除指定元素个数-stringlists："+shardedJedis.lrem("stringlists", 2, "vector")); 
//        System.out.println("删除指定元素之后-stringlists："+shardedJedis.lrange("stringlists", 0, -1));
//        // 删除区间以外的数据 
//        System.out.println("删除下标0-3区间之外的元素："+shardedJedis.ltrim("stringlists", 0, 3));
//        System.out.println("删除指定区间之外元素后-stringlists："+shardedJedis.lrange("stringlists", 0, -1));
//        // 列表元素出栈 
//        System.out.println("出栈元素："+shardedJedis.lpop("stringlists")); 
//        System.out.println("元素出栈后-stringlists："+shardedJedis.lrange("stringlists", 0, -1));
        
//        System.out.println("=============改=============");
//        // 修改列表中指定下标的值 
//        shardedJedis.lset("stringlists", 0, "hello list!"); 
//        System.out.println("下标为0的值修改后-stringlists："+shardedJedis.lrange("stringlists", 0, -1));
//        System.out.println("=============查=============");
        // 数组长度 
//        System.out.println("长度-stringlists："+shardedJedis.llen("stringlists"));
//        System.out.println("长度-numberlists："+shardedJedis.llen("numberlists"));
        // 排序 
        /*
         * list中存字符串时必须指定参数为alpha，如果不使用SortingParams，而是直接使用sort("list")，
         * 会出现"ERR One or more scores can't be converted into double"
         */
//        SortingParams sortingParameters = new SortingParams();
//        sortingParameters.alpha();
//        sortingParameters.limit(0, 3);
//        System.out.println("返回排序后的结果-stringlists："+shardedJedis.sort("stringlists",sortingParameters)); 
//        System.out.println("返回排序后的结果-numberlists："+shardedJedis.sort("numberlists"));
//        // 子串：  start为元素下标，end也为元素下标；-1代表倒数一个元素，-2代表倒数第二个元素
//        System.out.println("子串-第二个开始到结束："+shardedJedis.lrange("stringlists", 1, -1));
        // 获取列表指定下标的值 
//        System.out.println("获取下标为2的元素："+shardedJedis.lindex("stringlists", 2)+"\n");
    }
    public void show() {     
//        KeyOperate(); 
//        StringOperate(); 
        ListOperate(); 
//        SetOperate();
//        SortedSetOperate();
//        HashOperate(); 
        jedisPool.returnResource(jedis);
        shardedJedisPool.returnResource(shardedJedis);
    }
    public void fl(){
    	jedis.flushDB();
    }
    public void test(){
    	System.out.println(shardedJedis.get("stringlists"));
    }
    public static void main(String[] args) {
		new RedisClient().fl();
//		new RedisClient().test();
    	
	}
    
    class Test{
    	public Test(String name,String id){
    		this.name = name;
    		this.id= id ;
    	}
    	String name;
    	String id;
    }
}

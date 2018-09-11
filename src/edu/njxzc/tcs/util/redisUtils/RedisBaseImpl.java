package edu.njxzc.tcs.util.redisUtils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class RedisBaseImpl implements RedisI{
	
	public static final String TKBASE= "ykat:";

	@Autowired
	RedisInitBean jedis;
	
	/**
	 * 添加一个List集合
	 * @param domain
	 * @param list
	 * @return
	 */
	public boolean Listadd(String domain,List<String> list){
		return jedis.addList(TKBASE+domain, list);
	}
	
	/**
	 * 向一个list集合追加参数
	 * @param domain
	 * @param value
	 * @return
	 */
	public boolean Listappend(String domain,String value){
		return jedis.addList(TKBASE+domain, value);
	}
	
	/**
	 * 获取一个list集合的长度
	 * @param domain
	 * @return
	 */
	public Long Listcount(String domain){
		return jedis.countList(TKBASE+domain);
	}
	
	/**
	 * 自增键
	 * @param domain
	 * @return
	 */
	public Long incr(String domain){
		return jedis.incr(TKBASE+domain);
	}
	
	/**
	 * 从list中删除指定值
	 * @param domain
	 * @param count 每个值删除的个数 默认传1
	 * @param values 值名称集合
	 * @return
	 */
	public Integer ListremoveListValue(String domain,int count,List<String> values){
		return jedis.removeListValue(TKBASE+domain, count, values);
	}
	
	/**
	 * 添加set集合
	 * @param domain
	 * @param value
	 * @return
	 */
	public boolean Setadd(String domain,String value){
		return jedis.addSet(TKBASE+domain, value);
	}
	
	
	/**
	 * 判断 set 集合 是否包含某个键
	 * @param domain
	 * @param value
	 * @return
	 */
	public boolean SetcontainsIn(String domain,String value){
		return jedis.containsInSet(TKBASE+domain, value);
	}
	
	/**
	 * 从set中删除指定值
	 * @param domain
	 * @param count 每个值删除的个数 默认传1
	 * @param values 值名称集合
	 * @return
	 */
	public boolean SetdelSetValue(String domain,String value){
		return jedis.delSetValue(TKBASE+domain, value);
	}
	
	/**
	 * 随机弹出一个set集合内的参数
	 * @param domain
	 * @param value
	 * @return
	 */
	public boolean SetPopValue(String domain,String value){
		return jedis.spopSetValue(TKBASE+domain);
	}
	
	/**
	 * 删除hset中 名称为key 的值并返回删除的个数
	 * @param domain
	 * @param value
	 * @return
	 */
	public Long HSetDelValue(String domain,String key){
		return jedis.delHSet(TKBASE+domain, key);
	}
	
	/**
	 * 向hset 中添加键值对
	 * @param domain
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean HSetDelValue(String domain,String key,String value){
		return jedis.setHSet(TKBASE+domain, key, value);
	}
	
	/**
	 * 从hset中获取一个名称为key的value
	 * @param domain
	 * @param key
	 * @return
	 */
	public String HSetGetValue(String domain,String key){
		return jedis.getHSet(TKBASE+domain, key);
	}
	
	/**
	 * 对某个键值对设置过期时间
	 * @param domain
	 * @param seconds
	 * @return
	 */
	public Long expireKey(String domain,int seconds){
		return jedis.expire(TKBASE+domain, seconds);
	}
	
	


	
}

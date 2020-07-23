package com.lq.redis;

import redis.clients.jedis.Jedis;

import java.util.Collections;

/**
 * @author lq
 * @date 2020-06-11 10:11
 */
public class TestRedis {

    public static void main(String[] args) {
        setNx();

        expire();
    }

    public static String use1LockMark = "A001";

    /**
     * key 是分布式锁ID
     * value是上锁的请求标识
     */
    public static void setNx() {
        Jedis jedis = new Jedis("ceshi", 6388);
        jedis.auth("RedisTest123");
        String lockResult = jedis.set("orderNo123", use1LockMark, "NX", "PX", 10000);
        //返回ok表示上锁成功
        System.out.println(lockResult);
    }

    public static void expire() {
        Jedis jedis = new Jedis("ceshi", 6388);
        jedis.auth("RedisTest123");
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        Object expireResult = jedis.eval(script, Collections.singletonList("orderNo123"),
                Collections.singletonList(use1LockMark));
        System.out.println("expire result:" + expireResult.equals(Long.valueOf(1l)));
    }
}

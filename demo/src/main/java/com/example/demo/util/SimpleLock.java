package com.example.demo.util;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.JedisCluster;

@Slf4j
public class SimpleLock {
    private JedisLock jedisLock;
    private String lockKey;
    private JedisCluster jedis;
    private int timeoutMsecs;
    private int expireMsecs;

    public SimpleLock(String lockKey, JedisCluster jedis) {
        this(lockKey, 120000, 300000, jedis);
    }

    public SimpleLock(String lockKey, int timeoutMsecs, int expireMsecs, JedisCluster jedis) {
        this.lockKey = lockKey;
        this.jedis = jedis;
        this.timeoutMsecs = timeoutMsecs;
        this.expireMsecs = expireMsecs;
        this.jedisLock = new JedisLock(jedis, lockKey.intern(), timeoutMsecs, expireMsecs);
    }

    public synchronized void wrap(Runnable runnable) throws Exception {
        long begin = System.currentTimeMillis();
        try {
            log.info(
                    "begin lock,lockKey={},timeoutMsecs={},expireMsecs={}",
                    lockKey,
                    timeoutMsecs,
                    expireMsecs);
            if (jedisLock.acquire()) { // 启用锁
                runnable.run();
            } else {
                log.info("The time wait for lock more than [{}] ms ", timeoutMsecs);
                throw new Exception("can not get lock");
            }
        } catch (Throwable t) {
            // 分布式锁异常
            log.warn(t.getMessage(), t);
            throw t;
        } finally {
            this.lockRelease(jedisLock);
        }
        log.info("[{}]cost={}", lockKey, System.currentTimeMillis() - begin);
    }

    /**
     * 释放锁
     *
     * @param lock
     */
    private void lockRelease(JedisLock lock) {
        if (lock != null) {
            try {
                lock.release();
            } catch (Exception e) {

            }
        }
        log.debug(
                "release logck,lockKey={},timeoutMsecs={},expireMsecs={}",
                lockKey,
                timeoutMsecs,
                expireMsecs);
    }
}
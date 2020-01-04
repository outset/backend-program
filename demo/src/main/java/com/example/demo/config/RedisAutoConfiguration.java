package com.example.demo.config;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class RedisAutoConfiguration {

    @Value("${redis.node1.ip:127.0.0.1}")
    private String node1Ip;
    @Value("${redis.node1.port:6379}")
    private int node1Port;
    @Value("${redis.node.password:null}")
    private String password;
    @Value("${redis.connection_timeout:2000}")
    private int connectionTimeout;
    @Value("${redis.so_timeout:2000}")
    private int soTimeout;
    @Value("${redis.max_attempts:10}")
    private int maxAttempts;
    @Value("${redis.pool.maxTotal:800}")
    private int maxTotal;
    @Value("${redis.pool.minIdle:50}")
    private int minIdle;
    @Value("${redis.pool.maxIdle:200}")
    private int maxIdle;
    @Value("${redis.pool.maxWait:3000}")
    private int maxWaitMillis;

    @Bean
    public JedisCluster jedisCluster() {
        Set<HostAndPort> nodes = new HashSet<HostAndPort>();
        if (!node1Ip.equals("127.0.0.1") && !(node1Port == 0)) {
            nodes.add(new HostAndPort(node1Ip, node1Port));
        }

        if (nodes.isEmpty()) {
            return null;
        }

        GenericObjectPoolConfig pool = new GenericObjectPoolConfig();
        pool.setMaxTotal(maxTotal);
        pool.setMinIdle(minIdle);
        pool.setMaxIdle(maxIdle);
        pool.setMaxWaitMillis(maxWaitMillis);
        return new JedisCluster(nodes, connectionTimeout, soTimeout, maxAttempts, password, pool);
    }
}
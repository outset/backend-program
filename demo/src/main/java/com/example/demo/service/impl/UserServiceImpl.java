package com.example.demo.service.impl;

import com.example.demo.dao.UserMapper;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;


@Service("UserService")
//注解来统一指定value的值,这时候你在方法注解中就不用指定value值，优先级小于方法中的value。
//@CacheConfig(cacheNames = {"user"})
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate<Object, Object> stringRedisTemplate;


    @Override
    public User insertSelective(User record) {
        int flag = this.userMapper.insertSelective(record);
        if (flag == 0) {
            return null;
        }
        //插入成功就放入缓存
        stringRedisTemplate.opsForValue().set(record.getToken(), record);
        //这里是设置键的有效日期,不设置就是永久的token
//        stringRedisTemplate.expire(record.getToken(), 123L, TimeUnit.SECONDS);
        return record;
    }

    @Override

    public String selectByToken(String token) {
//        return this.userMapper.selectByToken(token);

        return null;
    }


}

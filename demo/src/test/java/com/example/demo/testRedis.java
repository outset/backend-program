package com.example.demo;

import com.example.demo.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class testRedis {

    @Autowired
    private RedisTemplate<Object, Object> stringRedisTemplate;

    @Test
    public void test() {
        User user = new User();
        user.setUid("testUid");
        user.setToken("1234567");
        stringRedisTemplate.opsForValue().set("1234567", user);
        ValueOperations operations = stringRedisTemplate.opsForValue();
        // 通过 token 从数据库中获取信息，如果没有验证失败
        // 如果通过一台设备登录，再通过另一台设备登录，第一台设备会自动登出
        // 此处已经将user放到缓存中，key值为token
        User openid = (User) operations.get("1234567");
        System.out.println(openid.getToken());
        Assert.assertEquals(user, openid);
    }
}

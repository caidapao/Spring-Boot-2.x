package com.caidapao;

import com.caidapao.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CaidapaoApplicationTests {


    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate<String, User> redisTemplate;

    @Test
    public void contextLoads() {
        // 保存字符串
        stringRedisTemplate.opsForValue().set("aaa", "111");
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));


        // 保存对象
        User user = new User("超人", 20);
        redisTemplate.opsForValue().set(user.getName(), user);

        user = new User("蝙蝠侠", 30);
        redisTemplate.opsForValue().set(user.getName(), user);

        user = new User("蜘蛛侠", 40);
        redisTemplate.opsForValue().set(user.getName(), user);

        Assert.assertEquals(20, redisTemplate.opsForValue().get("超人").getAge());
        Assert.assertEquals(30, redisTemplate.opsForValue().get("蝙蝠侠").getAge());
        Assert.assertEquals(40, redisTemplate.opsForValue().get("蜘蛛侠").getAge());

    }

}

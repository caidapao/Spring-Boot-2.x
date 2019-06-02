package com.caidapao;

import com.caidapao.entity.User;
import com.caidapao.repository.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CaidapaoApplicationTests {


    @Autowired
    private UserRepository userRepository;

    @Test
    public void contextLoads() {
        userRepository.save(new User("蔡大炮",24));
        userRepository.save(new User("蔡小炮",20));
        userRepository.save(new User("蔡二炮",22));
        userRepository.save(new User("Chasen",24));
        userRepository.save(new User("autumn",24));

        // 测试findAll, 查询所有记录
        Assert.assertEquals(5, userRepository.findAll().size());

        // 测试findByName, 查询姓名为蔡大炮的User
        Assert.assertEquals(24, userRepository.findByName("蔡大炮").getAge().longValue());

        // 测试findUser, 查询姓名为蔡二炮的User
        Assert.assertEquals(22, userRepository.findUser("蔡二炮").getAge().longValue());

        // 测试findByNameAndAge, 查询姓名为蔡小炮并且年龄为20的User
        Assert.assertEquals("蔡小炮", userRepository.findByNameAndAge("蔡小炮", 20).getName());

        // 测试删除姓名为蔡二炮的User
        userRepository.delete(userRepository.findByName("蔡二炮"));

        // 测试findAll, 查询所有记录, 验证上面的删除是否成功
        Assert.assertEquals(4, userRepository.findAll().size());

    }

}

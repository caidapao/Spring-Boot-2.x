package com.caidapao;

import com.caidapao.entity.User;
import com.caidapao.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CaidapaoApplicationTests {

    @Autowired
    private UserService userService;

    @Before
    public void contextLoads() {
        //先清空User表的所有用户
        userService.deleteAllUsers();
    }

    @Test
    public void test() {
        //插入数据
        userService.save(new User("aaa", 18));
        userService.save(new User("bbb", 28));
        userService.save(new User("ccc", 38));
        userService.save(new User("ddd", 48));
        userService.save(new User("eee", 58));
        userService.save(new User("fff", 68));

        //应该有6个用户
        List<User> userList = userService.getAllUsers();

        //编辑一个用户
        userService.update(new User("aaa", 17));

        //查看一下编辑的用户
        List<User> users = userService.findByName("aaa");

        //删除两个用户
        userService.deleteByName("bbb");
        userService.deleteByName("ccc");

        //查看剩下的用户，应该还有4个
        List<User> userList1 = userService.getAllUsers();

    }


}

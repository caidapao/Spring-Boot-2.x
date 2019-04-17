package com.caidapao;

import com.caidapao.entity.TestProperties;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CaidapaoApplicationTests {


    @Autowired
    private TestProperties properties;

    @Test
    public void contextLoads() {
        System.out.println("启动的端口号："+properties.getServerPort());
        System.out.println(properties.getDescr());
        Assert.assertEquals(properties.getName(),"蔡大炮");
        Assert.assertEquals(properties.getAddress(),"https://github.com/caidapao/spring-boot-1.x");


    }

}

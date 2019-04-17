package com.caidapao;

import com.alibaba.fastjson.JSONObject;
import com.caidapao.entity.User;
import com.caidapao.web.UserController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CaidapaoApplicationTests {

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }

    @Test
    public void testUserController() throws Exception {
        RequestBuilder requestBuilder = null;

        //1.get方式查看现在的用户列表，应该是一个空数组
        requestBuilder = get("/users/");
        mockMvc.perform(requestBuilder).andExpect(status().isOk()).andExpect(content().string(equalTo("[]")));

        //2.post方式保存一条
        requestBuilder = post("/users/")
                .param("id", "1")
                .param("name", "测试大师")
                .param("sex", "男");
        mockMvc.perform(requestBuilder).andExpect(content().string(equalTo("user_detail")));

        // 3、get获取user列表，应该能看到刚刚的记录
        requestBuilder = get("/users/");
        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[{\"id\":1,\"name\":\"测试大师\",\"sex\":\"男\"}]")));

        // 4、put修改id为1的user
        requestBuilder = put("/users/1")
                .param("name", "测试终极大师")
                .param("sex", "女");
        mockMvc.perform(requestBuilder)
                .andExpect(content().string(equalTo("user_detail")));

        // 5、get一个id为1的user
        requestBuilder = get("/users/1");
        mockMvc.perform(requestBuilder)
                .andExpect(content().string(equalTo("{\"id\":1,\"name\":\"测试终极大师\",\"sex\":\"女\"}")));

        // 6、del删除id为1的user
        requestBuilder = delete("/users/1");
        mockMvc.perform(requestBuilder)
                .andExpect(content().string(equalTo("user_detail")));

        // 7、get查一下user列表，应该为空
        requestBuilder = get("/users/");
        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));

        // 8、post JSON格式参数的请求，保存用户。这里使用了阿里巴巴的JSONUtil将bean转成JsonString，同时contentType要设置成ApplicantJson
        // 然后查一下user列表，应该有刚刚的caidapao

        User user = new User();
        user.setSex("男");
        user.setName("caidapao");
        user.setId(123L);
        requestBuilder = post("/users/save/").contentType(MediaType.APPLICATION_JSON).content(JSONObject.toJSONString(user));
        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk());

        requestBuilder = get("/users/");
        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[{\"id\":123,\"name\":\"caidapao\",\"sex\":\"男\"}]")));


    }

}

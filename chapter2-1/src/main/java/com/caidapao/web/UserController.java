package com.caidapao.web;

import com.caidapao.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by caixuan on 2019/4/9.
 * Time 23:38
 */
@RestController
@RequestMapping("/users")
public class UserController {

    //创建线程安全的Map
    private static Map<Long, User> users = Collections.synchronizedMap(new HashMap<>());

    /**
     *  GET请求
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> getUserList() {
        return new ArrayList<>(users.values());
    }

    /**
     * POST请求
     * ModelAttribute注解自动将参数中的值映射到User对应的属性下，
     *    如 ：localhost:8080/users?name=123&sex=男 将会映射到user对象的 name和sex字段中
     *    此处的 ModelAttribute注解也可以省略。
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String postUserView(@ModelAttribute User user) {
        users.put(user.getId(), user);
        return "user_detail";
    }

    /**
     *  GET请求
     *  通过PathVariable 注解绑定URL参数
     *  如：localhost:8080/users/12  12将会绑定到id这个形参上
     * @param id 用户id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        return users.get(id);
    }

    /**
     * PUT 请求，意为修改、或者覆盖
     * @param id 用户Id
     * @param user  用户
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String putUser(@PathVariable Long id, @ModelAttribute User user) {
        User u = users.get(id);
        u.setName(user.getName());
        u.setSex(user.getSex());
        users.put(id, u);
        return "user_detail";
    }

    /**
     * DELETE请求
     * @param id 用户id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        users.remove(id);
        return "user_detail";
    }

    /**
     * POST请求
     *  使用RequestBody注解来接受参数，大都数用来接收JSON格式的参数
     * @param user 用户
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public List<User> saveUser(@RequestBody User user) {
        users.put(user.getId(), user);
        return new ArrayList<>(users.values());
    }


}

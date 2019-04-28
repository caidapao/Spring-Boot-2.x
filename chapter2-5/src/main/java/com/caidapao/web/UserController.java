package com.caidapao.web;

import com.caidapao.entity.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/user")
public class UserController {
    //创建线程安全的Map
    private static Map<Long, User> users = Collections.synchronizedMap(new HashMap<>());

    /**
     * GET请求
     */
    @ApiOperation(value = "获取用户列表", notes = "获取所有用户")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> getUserList() {
        return new ArrayList<>(users.values());
    }

    /**
     * POST请求
     * ModelAttribute注解自动将参数中的值映射到User对应的属性下，
     * 如 ：localhost:8080/users?name=123&sex=男 将会映射到user对象的 name和sex字段中
     * 此处的 ModelAttribute注解也可以省略。
     */
    @ApiOperation(value = "创建一个用户1【错误示范，不需要加上 @ApiImplicitParam】", notes = "根据user对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @RequestMapping(value = "/postUserView1", method = RequestMethod.POST)
    public String postUserView1(@ModelAttribute User user) {
        users.put(user.getId(), user);
        return "user_detail";
    }

    /**
     * POST请求
     * ModelAttribute注解自动将参数中的值映射到User对应的属性下，
     * 如 ：localhost:8080/users?name=123&sex=男 将会映射到user对象的 name和sex字段中
     * 此处的 ModelAttribute注解也可以省略。
     */
    @ApiOperation(value = "创建一个用户2", notes = "根据user对象创建用户")
    @RequestMapping(value = "/postUserView2", method = RequestMethod.POST)
    public String postUserView2(@ModelAttribute User user) {
        users.put(user.getId(), user);
        return "user_detail";
    }


    /**
     * GET请求
     * 通过PathVariable 注解绑定URL参数
     * 如：localhost:8080/users/12  12将会绑定到id这个形参上
     *
     * @param id 用户id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        return users.get(id);
    }

    /**
     * PUT 请求，意为修改、或者覆盖
     *
     * @param id   用户Id
     * @param user 用户
     */
    @ApiOperation(value = "更新用户信息", notes = "根据url的id来指定更新的对象，并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    })
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
     *
     * @param id 用户id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        users.remove(id);
        return "user_detail";
    }

    /**
     * POST请求
     * 使用RequestBody注解来接受参数，大都数用来接收JSON格式的参数
     *
     * @param user 用户
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public List<User> saveUser(@RequestBody User user) {
        users.put(user.getId(), user);
        return new ArrayList<>(users.values());
    }

}
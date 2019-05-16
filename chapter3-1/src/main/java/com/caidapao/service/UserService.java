package com.caidapao.service;

import com.caidapao.entity.User;

import java.util.List;

/**
 * Created by caidapao on 2019/5/15
 * Time 21:22
 * Blog http://www.caidapao.com
 */
public interface UserService {

    void save(User user);

    List<User> findByName(String name);

    void update(User user);

    void deleteByName(String name);
}

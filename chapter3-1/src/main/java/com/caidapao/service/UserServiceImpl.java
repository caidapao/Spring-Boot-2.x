package com.caidapao.service;

import com.caidapao.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by caidapao on 2019/5/15
 * Time 21:23
 * Blog http://www.caidapao.com
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(User user) {
        jdbcTemplate.update("insert into USER(NAME,AGE) value (?,?)",user.getName(),user.getAge());
    }

    @Override
    public List<User> findByName(String name) {
//        return jdbcTemplate.query("select * from USER where name = ? ",name);
        return null;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void deleteByName(String name) {

    }
}

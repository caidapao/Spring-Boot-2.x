package com.caidapao.service;

import com.caidapao.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
        String sql = "select * from USER where name = ? ";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(User.class),name);
    }

    @Override
    public List<User> getAllUsers() {
        String sql = "select * from USER ";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public void update(User user) {
        jdbcTemplate.update("UPDATE USER SET AGE = ? where name = ? ",user.getAge(),user.getName());

    }

    @Override
    public void deleteByName(String name) {
        jdbcTemplate.update("delete from user where name = ? " ,name);
    }

    @Override
    public void deleteAllUsers() {
        jdbcTemplate.update("delete from user");
    }
}

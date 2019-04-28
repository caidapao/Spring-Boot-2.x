package com.caidapao.entity;

/**
 * Created by caidapao on 2019/4/26
 * Time 22:31
 * Blog http://www.caidapao.com
 */
public class User {

    private Long id;
    private String name;
    private String sex;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}

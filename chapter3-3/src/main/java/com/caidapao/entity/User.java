package com.caidapao.entity;

import java.io.Serializable;

/**
 * Created by caidapao on 2019/6/7
 * Time 17:50
 * Blog http://www.caidapao.com
 */
public class User implements Serializable {

    private static final long serializableUID = 1L;

    private String name;

    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

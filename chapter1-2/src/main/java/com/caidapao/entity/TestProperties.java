package com.caidapao.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by caixuan on 2019/4/7.
 * Time 18:43
 */
@Component
public class TestProperties {

    @Value("${com.caidapao.name}")
    private String name;
    @Value("${com.caidapao.github.spring.boot.1.x}")
    private String address;
    @Value("${com.caidapao.descr}")
    private String descr;
    @Value("${server.port}")
    private int serverPort;

    public int getServerPort() {
        return serverPort;
    }

    public void setServerPort(int serverPort) {
        this.serverPort = serverPort;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }


}

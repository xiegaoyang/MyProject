package com.xgy.mytomcat.dal.model;

import java.io.Serializable;

/**
 * Created by hadoop on 2017/6/11.
 */
public class Account implements Serializable {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
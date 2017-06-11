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
    private String sex;
    private String work;
    private String number;
    private String address;

    /**
     * 密码
     */
    private String password;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



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

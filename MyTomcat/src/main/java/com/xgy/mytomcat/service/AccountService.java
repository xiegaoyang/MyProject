package com.xgy.mytomcat.service;

/**
 * Created by hadoop on 2017/6/11.
 */
public interface AccountService {
    boolean registerAccount(String username, String password);
    boolean validateAccount(String username, String password);
}

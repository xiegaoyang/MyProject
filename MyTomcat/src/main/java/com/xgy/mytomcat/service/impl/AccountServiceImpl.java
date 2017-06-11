package com.xgy.mytomcat.service.impl;

import com.xgy.mytomcat.dal.MyDal;
import com.xgy.mytomcat.dal.model.Account;
import com.xgy.mytomcat.service.AccountService;

/**
 * Created by hadoop on 2017/6/11.
 */
public class AccountServiceImpl implements AccountService {




    @Override
    public boolean registerAccount(String username, String password) {


        return true;
    }

    public boolean validateAccount(String username, String password) {

        MyDal myDal = new MyDal();
        Account account = myDal.getAccount(username);
        if (null == account || !account.getPassword().equals(password)) {
            return false;
        }

        return true;
    }
}

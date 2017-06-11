package com.xgy.mytomcat.dal;

import com.xgy.mytomcat.dal.dao.AccountDao;
import com.xgy.mytomcat.dal.dao.impl.AccountDaoImpl;
import com.xgy.mytomcat.dal.model.Account;

/**
 * Created by hadoop on 2017/6/11.
 */
public class MyDal {

    private AccountDao accountDao = new AccountDaoImpl();

    public Account getAccount(String username) {
        return accountDao.getAccount(username);
    }

}

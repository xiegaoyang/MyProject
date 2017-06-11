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

    public boolean createAccount(String username, String sex, String work, String number, String address, String password) {
        Account account = new Account();
        account.setUsername(username);
        account.setSex(sex);
        account.setWork(work);
        account.setNumber(number);
        account.setAddress(address);
        account.setPassword(password);
        return accountDao.createAccount(account);
    }

}

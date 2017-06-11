package com.xgy.mytomcat.dal.dao;

import com.xgy.mytomcat.dal.model.Account;

/**
 * Created by hadoop on 2017/6/11.
 */
public interface AccountDao {

    boolean createAccount(Account account);
    Account getAccount(String number);
    boolean updateAccount(Account account);

}

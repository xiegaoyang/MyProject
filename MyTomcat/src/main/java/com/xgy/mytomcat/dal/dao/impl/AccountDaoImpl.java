package com.xgy.mytomcat.dal.dao.impl;

import com.xgy.mytomcat.dal.dao.AccountDao;
import com.xgy.mytomcat.dal.model.Account;
import com.xgy.mytomcat.util.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by hadoop on 2017/6/11.
 */
public class AccountDaoImpl implements AccountDao {

    public boolean createAccount(Account account) {

        return true;
    }


    public Account getAccount(String username) {

        String sql = "select * from account where name='" + username + "'";

        Connection conn=null;
        Statement stat=null;
        ResultSet rs=null;

        try {
            conn = JDBCUtils.getConn();
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            if(rs.next()){
                Account account = new Account();
                account.setUsername(rs.getString("name"));
                account.setPassword(rs.getString("password"));
                return account;
            }else{
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally{
            JDBCUtils.closeConn(rs, stat, conn);
        }
    }
}

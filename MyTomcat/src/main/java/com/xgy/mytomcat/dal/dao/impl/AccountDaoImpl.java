package com.xgy.mytomcat.dal.dao.impl;

import com.xgy.mytomcat.dal.dao.AccountDao;
import com.xgy.mytomcat.dal.model.Account;
import com.xgy.mytomcat.service.AccountService;
import com.xgy.mytomcat.service.impl.AccountServiceImpl;
import com.xgy.mytomcat.util.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by hadoop on 2017/6/11.
 */
public class AccountDaoImpl implements AccountDao {

    public boolean createAccount(Account account) {

        String sql = "insert into account VALUE ('" + account.getUsername() + "', " +
                "'" + account.getSex() + "', " +
                "'" + account.getWork() + "', " +
                "'" + account.getNumber() + "', " +
                "'" + account.getAddress() + "', " +
                "'" + account.getPassword() +
                "');";

        System.out.println(sql);

        Connection conn=null;
        Statement stat=null;
        ResultSet rs=null;

        try {
            conn = JDBCUtils.getConn();
            stat = conn.createStatement();
            int results = stat.executeUpdate(sql);
            if (-1 == results) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally{
            JDBCUtils.closeConn(rs, stat, conn);
        }
    }


    public Account getAccount(String number) {

        String sql = "select * from account where number='" + number + "'";

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
                account.setSex(rs.getString("sex"));
                account.setWork(rs.getString("work"));
                account.setAddress(rs.getString("address"));
                account.setNumber(rs.getString("number"));
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

    @Override
    public boolean updateAccount(Account account) {

        String sql = "UPDATE account SET " +
                "name='" + account.getUsername() + "', " +
                "sex='" + account.getSex() + "', " +
                "work='" + account.getWork() + "', " +
                "address='" + account.getAddress() + "' where number='" + account.getNumber() + "';";

        System.out.println("sql = " + sql);

        Connection conn=null;
        Statement stat=null;
        ResultSet rs=null;

        try {
            conn = JDBCUtils.getConn();
            stat = conn.createStatement();
            int results = stat.executeUpdate(sql);
            if (-1 == results) {
                return false;
            }
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally{
            JDBCUtils.closeConn(rs, stat, conn);
        }

    }

    public static void main(String[] args) {

        AccountDao accountDao = new AccountDaoImpl();

        Account account = new Account();
        account.setUsername("Ð»¸ßÑï");
        account.setSex("ÄÐ");
        account.setWork("11");
        account.setAddress("22");
        account.setNumber("15919492257");
        account.setPassword("ab12341234");

        accountDao.createAccount(account);


    }

}

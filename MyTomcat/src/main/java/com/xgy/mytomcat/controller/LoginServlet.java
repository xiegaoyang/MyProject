package com.xgy.mytomcat.controller;

import com.xgy.mytomcat.service.AccountService;
import com.xgy.mytomcat.service.impl.AccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by hadoop on 2017/6/11.
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        String username = "";
        String password = "";

       username = req.getParameter("username");
//        try {
//            username = new String(req.getParameter("username").getBytes("ISO-8859-1"), "UTF-8");
//        } catch (UnsupportedEncodingException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        password = req.getParameter("password");

        System.out.println("username : " + username + ", password : " + password);

        if (StringUtils.isNotEmpty(username) && StringUtils.isNotEmpty(password)) {
            AccountService accountService = new AccountServiceImpl();
            resp.setHeader("content-type", "text/html;charset=UTF-8");
            PrintWriter out = resp.getWriter();
            if (accountService.validateAccount(username, password)) {
                out.print("µÇÂ½³É¹¦, username = " + username + ", password = " + password);
            } else {
                out.print("µÇÂ½Ê§°Ü, username = " + username + ", password = " + password);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost");
        doGet(req, resp);
    }
}

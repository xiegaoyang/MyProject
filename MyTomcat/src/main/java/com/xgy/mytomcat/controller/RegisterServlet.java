package com.xgy.mytomcat.controller;

import com.xgy.mytomcat.log.Log;
import com.xgy.mytomcat.service.AccountService;
import com.xgy.mytomcat.service.impl.AccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by hadoop on 2017/6/11.
 */
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        String username = req.getParameter("username");
        String sex = req.getParameter("sex");
        String work = req.getParameter("work");
        String number = req.getParameter("number");
        String address = req.getParameter("address");
        String password = req.getParameter("password");
        String password2 = req.getParameter("password2");

        System.out.println(
                username + ", " +
                sex + ", " +
                work + ", " +
                address + ", " +
                number + ", " +
                password + ", " +
                password2
        );

        System.out.println("doPost");

        resp.setHeader("content-type", "text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        AccountService accountService = new AccountServiceImpl();
        if (!accountService.registerAccount(username, sex, work, number, address, password)) {
            Log.getInstance().error("×¢²áÊ§°Ü");
            out.print("×¢²áÊ§°Ü");
        } else {
            out.print("×¢²á³É¹¦");
        }


    }
}

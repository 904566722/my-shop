package com.hhhqqq.my.shop.web.controller;

import com.hhhqqq.my.shop.commons.context.SpringContext;
import com.hhhqqq.my.shop.entity.User;
import com.hhhqqq.my.shop.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;

/**
 * @ClassName LoginController
 * @Description TODO
 * @Author HHQ
 * @Date 2020/3/30 15:00
 * @Version 1.0
 */
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        SpringContext springContext = new SpringContext();
        UserService userService = (UserService) springContext.getBean("userService");
        User user = userService.login(email, password);

        if (user != null) {
            resp.sendRedirect("/main.jsp");
        }
        else {
            req.setAttribute("loginErrorMessage","用户名或密码错误");
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        }
    }
}

package com.hhhqqq.my.shop.web.controller;

import com.hhhqqq.my.shop.commons.context.SpringContext;
import com.hhhqqq.my.shop.commons.utils.CookieUtils;
import com.hhhqqq.my.shop.entity.User;
import com.hhhqqq.my.shop.service.UserService;
import org.apache.commons.lang3.StringUtils;

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

    private static final String COOKIE_NAME_USER_INFO = "userInfo";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userInfo = CookieUtils.getCookieValue(req, COOKIE_NAME_USER_INFO);

        if (StringUtils.isNoneBlank(userInfo)) {
            String[] userInfoArray = userInfo.split(":");
            String email = userInfoArray[0];
            String password = userInfoArray[1];

            req.setAttribute("email", email);
            req.setAttribute("password", password);
            req.setAttribute("isRemember", true);
        }

        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        boolean isRemember = req.getParameter("isRemember") == null ? false : true;

        SpringContext springContext = new SpringContext();
        UserService userService = (UserService) springContext.getBean("userService");
        User user = userService.login(email, password);

        if (!isRemember) {
            CookieUtils.deleteCookie(req, resp, COOKIE_NAME_USER_INFO);
        }

        if (user != null) {
            if (isRemember) {
                CookieUtils.setCookie(req, resp, COOKIE_NAME_USER_INFO, String.format("%s:%s", email, password), 7*24*60*60);
            }

            resp.sendRedirect("/main.jsp");
        }
        else {
            req.setAttribute("loginErrorMessage","用户名或密码错误");
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        }
    }
}

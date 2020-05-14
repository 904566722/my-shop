package com.hhhqqq.my.shop.service.impl;

import com.hhhqqq.my.shop.commons.context.SpringContext;
import com.hhhqqq.my.shop.dao.UserDao;
import com.hhhqqq.my.shop.entity.User;
import com.hhhqqq.my.shop.service.UserService;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    public User login(String email, String password) {
        SpringContext springContext = new SpringContext();
        UserDao userDao = (UserDao) springContext.getBean("userDao");
        return userDao.getUser(email, password);
    }
}

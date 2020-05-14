package com.hhhqqq.my.shop.service;

import com.hhhqqq.my.shop.entity.User;

public interface UserService {
    /**
     * 登录
     * @author HHQ
     * @param email 邮箱
     * @param password 密码
     * @return com.hhhqqq.my.shop.entity.User 成功返回：用户；错误返回：null
     */
    public User login(String email, String password);
}

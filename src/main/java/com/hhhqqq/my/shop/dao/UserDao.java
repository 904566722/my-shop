package com.hhhqqq.my.shop.dao;

import com.hhhqqq.my.shop.entity.User;

public interface UserDao {
    /**
     * 根据邮箱和密码返回用户
     * @author HHQ
     * @param email 邮箱
     * @param password 密码
     * @return com.hhhqqq.my.shop.entity.User 找到返回：用户； 没找到返回：null
     */
    public User getUser(String email, String password);
}

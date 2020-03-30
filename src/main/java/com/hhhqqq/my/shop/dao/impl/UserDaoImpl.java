package com.hhhqqq.my.shop.dao.impl;

import com.hhhqqq.my.shop.dao.UserDao;
import com.hhhqqq.my.shop.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName UserDaoImpl
 * @Description TODO
 * @Author HHQ
 * @Date 2020/3/30 14:03
 * @Version 1.0
 */
public class UserDaoImpl implements UserDao {
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    public User getUser(String email, String password) {
        logger.debug("调用 getUser, 参数为：email:{} password:{}", email, password);

        User user = null;

        if ("admin@qq.com".equals(email)) {
            if ("admin".equals(password)) {
                user = new User();
                user.setEmail("admin@qq.com");
                user.setUsername("HHQ");

                logger.info("获取用户 成功 用户：{}", user.getUsername());
            }
        }
        else {
            logger.warn("获取用户 失败 用户：{}", email);
        }

        return user;
    }
}

package com.atguigu.bookstore.service;

import com.atguigu.bookstore.dao.UserDao;
import com.atguigu.bookstore.dao.impl.UserDaoImpl;
import com.atguigu.bookstore.domain.User;

/**
 * @author Administrator
 * @create 2018-09-11 11:09
 **/
public class UserService {

    private UserDao userDao = new UserDaoImpl();

    public User getUserByUserName(String username) {
        return userDao.getUser(username);
    }

}

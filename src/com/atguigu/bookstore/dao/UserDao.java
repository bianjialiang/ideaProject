package com.atguigu.bookstore.dao;

import com.atguigu.bookstore.domain.User;

public interface UserDao {
    /*
    根据用户名获取user对象
     */
    public abstract User getUser(String username);
}

package com.atguigu.bookstore.dao.impl;

import com.atguigu.bookstore.dao.UserDao;
import com.atguigu.bookstore.domain.User;

/**
 * @author Administrator
 * @create 2018-09-11 10:07
 **/
public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User getUser(String username) {
        String sql = "select userId,username,accountId" + "from userinfo where username=?";
        return (User) query(sql, username);
    }
}

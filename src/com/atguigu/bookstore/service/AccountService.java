package com.atguigu.bookstore.service;

import com.atguigu.bookstore.dao.AccountDao;
import com.atguigu.bookstore.dao.impl.AccountDaoImpl;
import com.atguigu.bookstore.domain.Account;

/**
 * @author Administrator
 * @create 2018-09-11 11:06
 **/
public class AccountService {

    private AccountDao accountDao = new AccountDaoImpl();

    public Account getAccount(int accountId) {
        return accountDao.get(accountId);
    }
}

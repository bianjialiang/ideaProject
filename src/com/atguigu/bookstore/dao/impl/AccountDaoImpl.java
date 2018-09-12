package com.atguigu.bookstore.dao.impl;

import com.atguigu.bookstore.dao.AccountDao;
import com.atguigu.bookstore.domain.Account;

/**
 * @author Administrator
 * @create 2018-09-10 21:58
 **/
public class AccountDaoImpl extends BaseDao implements AccountDao {
    @Override
    public Account get(Integer accountId) {

        String sql = "select accountId,balance from account where accountId=?";

        return (Account) query(sql, accountId);
    }

    @Override
    public void updateBalance(Integer accountId, float amount) {

        String sql = "update account set balance=balance-? where accountId=?";

        update(sql, amount, accountId);

    }
}

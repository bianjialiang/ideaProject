package com.atguigu.bookstore.dao;

import com.atguigu.bookstore.domain.Account;

public interface AccountDao {

    /*
    根据account获取account对应的对象
     */
    public abstract Account get(Integer accountId);

    /*
    根据传入的accountId,amount 更新指定账户的余额：扣除amount指定的钱数
     */
    public abstract void updateBalance(Integer accountId, float amount);
}

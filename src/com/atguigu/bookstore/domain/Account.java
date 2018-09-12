package com.atguigu.bookstore.domain;

public class Account {

    private  int accountId;

    private  int balance;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "account{" +
                "accountId=" + accountId +
                ", balance=" + balance +
                '}';
    }


}

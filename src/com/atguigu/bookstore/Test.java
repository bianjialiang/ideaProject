package com.atguigu.bookstore;

import com.atguigu.bookstore.domain.Account;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @create 2018-09-11 14:55
 **/
public class Test {
    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();
        Account account = new Account();
        account.setAccountId(1);
        account.setBalance(5);
        Account account1 = new Account();
        account1.setAccountId(2);
        account1.setBalance(4);
        accounts.add(account);
        accounts.add(account1);
        System.out.println("����һ��СС��");
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println(accounts.get(i));
        }
    }
}

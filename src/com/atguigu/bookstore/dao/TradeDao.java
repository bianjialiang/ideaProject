package com.atguigu.bookstore.dao;

import com.atguigu.bookstore.domain.Trade;

import java.util.Set;

/**
 * @author Administrator
 * @create 2018-09-10 21:51
 **/
public interface TradeDao {

    /*
    向数据库插入Trade对象
     */
    public abstract void insert(Trade trade);

    /*
    根据userId获取和其关联的Trade的集合
     */
    public abstract Set<Trade> getTradesWithUserId(Integer userId);
}

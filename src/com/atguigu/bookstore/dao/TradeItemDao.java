package com.atguigu.bookstore.dao;

import com.atguigu.bookstore.domain.TradeItem;

import java.util.Collection;
import java.util.HashSet;

/**
 * @author Administrator
 * @create 2018-09-10 21:55
 **/
public interface TradeItemDao {

    /*
    批量保存TradeIten对象
     */
    public abstract void batchSave(Collection<TradeItem> items);

    /*
    根据TradeId获取和其关联的TradeItem的集合
     */
    public abstract HashSet getTradeItemsWithTradeId(Integer tradeId);
}

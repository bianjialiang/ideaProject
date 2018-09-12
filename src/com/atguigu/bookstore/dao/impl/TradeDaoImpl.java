package com.atguigu.bookstore.dao.impl;

import com.atguigu.bookstore.dao.TradeDao;
import com.atguigu.bookstore.domain.Trade;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author Administrator
 * @create 2018-09-11 9:34
 **/
public class TradeDaoImpl extends BaseDao implements TradeDao {
    @Override
    public void insert(Trade trade) {
        String sql = "insert into trade (userId,tradetime) values" + "(?,?)";

        long tradeId = insert(sql, trade.getUserId(), trade.getTradeTime());
        trade.setTradeId((int) tradeId);
    }

    @Override
    public Set<Trade> getTradesWithUserId(Integer userId) {

        String sql = "select tradeId,userId,tradetime from trade " + " where userId=? order by tradeTime desc";
        return new LinkedHashSet<>(queryForList(sql, userId));
    }
}

package com.atguigu.bookstore.dao.impl;

import com.atguigu.bookstore.dao.TradeItemDao;
import com.atguigu.bookstore.domain.TradeItem;

import java.util.*;

/**
 * @author Administrator
 * @create 2018-09-11 9:46
 **/
public class TradeItemDaoImpl extends BaseDao<TradeItem> implements TradeItemDao {
    @Override
    public void batchSave(Collection<TradeItem> items) {

        String sql = "insert into tradeitem(bookid,quantity,tradeid)" + "values(?,?,?)";
        Object[][] params = new Object[items.size()][3];
        List<TradeItem> tradeItems = new ArrayList<>();
        for (int i = 0; i < tradeItems.size(); i++) {
            params[i][0] = tradeItems.get(i).getBookId();
            params[i][1] = tradeItems.get(i).getQuantity();
            params[i][2] = tradeItems.get(i).getTradeId();
        }
        batch(sql, params);

    }

    @Override
    public HashSet getTradeItemsWithTradeId(Integer tradeId) {

        String sql = "select itemId tradeItemId,bookId" + "quantity ,tradeId from tradeitem where tradeid=?";
        return new HashSet<>(queryForList(sql, tradeId));
    }

}

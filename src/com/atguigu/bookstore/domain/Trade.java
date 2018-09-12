package com.atguigu.bookstore.domain;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

public class Trade {

    private int tradeId;

    private Date tradeTime;

    private Set<TradeItem> itmes = new LinkedHashSet<TradeItem>();

    private Integer userId;

    public int getTradeId() {
        return tradeId;
    }

    public void setTradeId(int tradeId) {
        this.tradeId = tradeId;
    }

    public Date getTradeTime() {
        return tradeTime;
    }

    public void setTradeTime(Date tradeTime) {
        this.tradeTime = tradeTime;
    }

    public Set<TradeItem> getItmes() {
        return itmes;
    }

    public void setItmes(Set<TradeItem> itmes) {
        this.itmes = itmes;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "tradeId=" + tradeId +
                ", tradeTime=" + tradeTime +
                ", itmes=" + itmes +
                ", userId=" + userId +
                '}';
    }
}

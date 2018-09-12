package com.atguigu.bookstore.domain;

public class TradeItem {

    private  Integer tradeItemId;

    private  Book book;

    private  int quantity;

    private  Integer tradeId;

    private  Integer bookId;

    public Integer getTradeItemId() {
        return tradeItemId;
    }

    public void setTradeItemId(Integer tradeItemId) {
        this.tradeItemId = tradeItemId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Integer getTradeId() {
        return tradeId;
    }

    public void setTradeId(Integer tradeId) {
        this.tradeId = tradeId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        return "TradeItem{" +
                "tradeItemId=" + tradeItemId +
                ", book=" + book +
                ", quantity=" + quantity +
                ", tradeId=" + tradeId +
                ", bookId=" + bookId +
                '}';
    }
}

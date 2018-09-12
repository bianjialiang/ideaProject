package com.atguigu.bookstore.domain;

public class ShoppingCartItem {

    private Book book;

    private int quantity;

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


    public ShoppingCartItem(Book book) {
        this.book = book;
        this.quantity = 1;
    }

    @Override
    public String toString() {
        return "ShoppingCartItem{" +
                "book=" + book +
                ", quantity=" + quantity +
                '}';
    }

    /*
    返回该商品在购物车中的钱数
     */
    public float getItemMoney() {
        return book.getPrice() * quantity;
    }

    /*
    使商品数量+1
     */
    public void increment() {
        quantity++;
    }
}

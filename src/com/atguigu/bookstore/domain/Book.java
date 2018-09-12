package com.atguigu.bookstore.domain;

import java.util.Date;

public class Book {

    private int id;

    private String author;

    private String title;

    private float price;

    private Date pushingDate;

    private int salesmount;

    private int storeNumber;

    private String remark;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getPushingDate() {
        return pushingDate;
    }

    public void setPushingDate(Date pushingDate) {
        this.pushingDate = pushingDate;
    }

    public int getSalesmount() {
        return salesmount;
    }

    public void setSalesmount(int salesmount) {
        this.salesmount = salesmount;
    }

    public int getStoreNumber() {
        return storeNumber;
    }

    public void setStoreNumber(int storeNumber) {
        this.storeNumber = storeNumber;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", pushingDate=" + pushingDate +
                ", salesmount=" + salesmount +
                ", storeNumber=" + storeNumber +
                ", remark='" + remark + '\'' +
                '}';
    }
}

package com.atguigu.bookstore.dao;

import com.atguigu.bookstore.domain.Book;
import com.atguigu.bookstore.domain.CriteriaBook;
import com.atguigu.bookstore.domain.Page;
import com.atguigu.bookstore.domain.ShoppingCartItem;

import java.util.Collection;
import java.util.List;

public interface BookDao {


    /*
    根据id获取指定book对象
     */
    public abstract Book getBook(int id);

    /*
    根据传入的CriteriaBook对象 返回对应的page对象
     */
    public abstract Page<Book> getPage(CriteriaBook cb);

    /*
    根据传入的criteria对象返回其对应的记录数
     */
    public abstract long getTotalBookNumber(CriteriaBook criteriaBook);

    /*
    根据传入的CriteriaBook和pageSize返回当前页对应的list
     */
    public abstract List<Book> getPageList(CriteriaBook criteriaBook, int pageSize);

    /*
    返回指定的id的book的storenumber字段值
     */
    public abstract int getStoreNumber(Integer id);

    /*
    根据传入的ShoppingcartItem的集合
    批量更新books数据表的storenumer和salesNumber字段的值
     */
    public abstract void batchUpdateStoreNumberAndSalesAmount(Collection<ShoppingCartItem> items);

}

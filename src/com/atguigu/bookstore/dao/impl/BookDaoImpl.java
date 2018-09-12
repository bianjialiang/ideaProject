package com.atguigu.bookstore.dao.impl;

import com.atguigu.bookstore.dao.BookDao;
import com.atguigu.bookstore.domain.Book;
import com.atguigu.bookstore.domain.CriteriaBook;
import com.atguigu.bookstore.domain.Page;
import com.atguigu.bookstore.domain.ShoppingCartItem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Administrator
 * @create 2018-09-11 9:33
 **/
public class BookDaoImpl extends BaseDao implements BookDao {
    @Override
    public Book getBook(int id) {
        String sql = "select id,author,title,price,publishingDate," +
                "salesAmount,storeNumber,remark from mybooks where id=?";
        return (Book) query(sql, id);
    }

    @Override
    public Page<Book> getPage(CriteriaBook cb) {
        Page<Book> page = new Page<>(cb.getPageNo());
        page.setTotalItemNumber(getTotalBookNumber(cb));
        cb.setPageNo(page.getPageNo());
        page.setList(getPageList(cb, 3));
        return page;
    }

    @Override
    public long getTotalBookNumber(CriteriaBook criteriaBook) {
        String sql = "select count(id) from mybooks where price>=? and price<=?";
        return 0;
    }

    @Override
    public List<Book> getPageList(CriteriaBook criteriaBook, int pageSize) {
        String sql = "select id,author,title,price,publishDate," + "salesAmount,storeNumber,remark from mybooks" +
                "where price>=? and price <=?" + "limit ?,?";
        return queryForList(sql, criteriaBook.getMinPrice(), criteriaBook.getMaxPrice(), (criteriaBook.getPageNo() - 1) * pageSize, pageSize);
    }

    @Override
    public int getStoreNumber(Integer id) {
        String sql = "select storeNumber from mybooks where id=?";
        return 0;
    }

    @Override
    public void batchUpdateStoreNumberAndSalesAmount(Collection<ShoppingCartItem> items) {
        String sql = "UPDATE mybooks SET salesAmount = salesAmount + ?, " +
                "storeNumber = storeNumber - ? " +
                "WHERE id = ?";
        Object[][] params = null;
        params = new Object[items.size()][3];
        List<ShoppingCartItem> scis = new ArrayList<>(items);
        for (int i = 0; i < items.size(); i++) {
            params[i][0] = scis.get(i).getQuantity();
            params[i][1] = scis.get(i).getQuantity();
            params[i][2] = scis.get(i).getBook().getId();
        }
        batch(sql, params);
    }
}

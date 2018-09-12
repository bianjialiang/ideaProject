package com.atguigu.bookstore.dao;

import java.util.List;

/*
Dao接口的定义，Dao的基本操作
 */
public interface Dao<T> {

    long insert(String sql, Object... args);

    /*
    执行更新操作
     */
    void update(String sql, Object... args);

    /*
    执行查询操作
     */
    T query(String sql, Object... args);

    /*
    执行多条记录查询操作
     */
    List<T> queryForList(String sql, Object... args);


    /*
    执行批量更新操作
     */
    void batch(String sql, Object[]... params);
}

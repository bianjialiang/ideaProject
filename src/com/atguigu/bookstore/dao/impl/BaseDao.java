package com.atguigu.bookstore.dao.impl;

import com.atguigu.bookstore.dao.Dao;
import com.atguigu.bookstore.util.ReflectionUtils;
import com.atguigu.bookstore.web.ConnectionContext;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.*;
import java.util.List;

/**
 * @author Administrator
 * @create 2018-09-10 22:02
 **/
public class BaseDao<T> implements Dao<T> {

    private QueryRunner queryRunner = new QueryRunner();

    private Class<T> clazz;

    public BaseDao() {
        clazz = ReflectionUtils.getSuperGenricType(getClass());
    }

    @Override
    public long insert(String sql, Object... args) {

        long id = 0;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        connection = ConnectionContext.getInstance().get();
        try {
            ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            if (args != null) {
                for (int i = 0; i < args.length; i++) {
                    ps.setObject(i + 1, args[i]);
                }
            }
            ps.executeUpdate();
            //获取生成的主键值
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getLong(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public void update(String sql, Object... args) {

        Connection connection = null;
        connection = ConnectionContext.getInstance().get();
        try {
            queryRunner.update(connection, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public T query(String sql, Object... args) {

        Connection connection = null;
        try {
            connection = ConnectionContext.getInstance().get();
            return queryRunner.query(connection, sql, new BeanHandler<>(clazz), args);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<T> queryForList(String sql, Object... args) {

        Connection connection = null;
        try {
            connection = ConnectionContext.getInstance().get();
            return queryRunner.query(connection, sql, new BeanListHandler<>(clazz), args);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void batch(String sql, Object[]... params) {
        Connection connection=null;
        connection=ConnectionContext.getInstance().get();
        try {
            queryRunner.batch(connection,sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

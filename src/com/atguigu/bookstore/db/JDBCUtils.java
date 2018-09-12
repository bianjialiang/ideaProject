package com.atguigu.bookstore.db;

import com.atguigu.bookstore.exception.DBException;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Administrator
 * @create 2018-09-10 9:24
 **/
public class JDBCUtils {

    private static DataSource dataSource = null;

    static {
        dataSource = new ComboPooledDataSource("javawebapp");
    }

    //获取数据库连接
    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("数据库连接错误！");
        }
    }

    //关闭数据库连接
    public static void release(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new DBException("数据库连接错误！");
            }
        }
    }

    //关闭数据库连接
    public  static void release(ResultSet rs, Statement statement){
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new DBException("数据库连接错误");
            }
        }

        if (statement!=null) try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("数据库连接错误！");
        }
    }
}

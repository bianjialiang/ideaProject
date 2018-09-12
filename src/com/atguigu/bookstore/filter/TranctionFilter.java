package com.atguigu.bookstore.filter;

import com.atguigu.bookstore.db.JDBCUtils;
import com.atguigu.bookstore.web.ConnectionContext;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

/**
 * @author Administrator
 * @create 2018-09-10 9:37
 **/
public class TranctionFilter implements Filter {
    @Override
    public boolean isLoggable(LogRecord record) {
        return false;
    }

    public void destory() {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException {

        Connection connection = null;

        try {
            //1,获取数据库连接
            connection = JDBCUtils.getConnection();

            //2.开启事务
            connection.setAutoCommit(false);

            //3.利用THReadLocal把连接和当前线程绑定
            ConnectionContext.getInstance().bind(connection);

            //4.把请求转给目标servlet
            chain.doFilter(request, response);

            //5.提交事务
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            //6,回滚事务
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

            HttpServletResponse resp = (HttpServletResponse) response;
            HttpServletRequest req = (HttpServletRequest) request;
            resp.sendRedirect(req.getContextPath() + "/error-1.jsp");

        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //7.接触绑定
            ConnectionContext.getInstance().remove();

            //8.关闭连接
            JDBCUtils.release(connection);
        }

    }
}

package com.atguigu.bookstore.filter;

import javax.servlet.*;
import java.io.IOException;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

/**
 * @author Administrator
 * @create 2018-09-10 15:25
 **/
public class EncodingFilter implements Filter {
    @Override
    public boolean isLoggable(LogRecord record) {
        return false;
    }

    public EncodingFilter() {

    }

    public void destory() {

    }

    private FilterConfig filterConfig = null;

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String encoding = filterConfig.getServletContext().getInitParameter("encoding");
        request.setCharacterEncoding(encoding);
        chain.doFilter(request, response);
    }

    public void init(FilterConfig fConfig) {
        this.filterConfig = fConfig;
    }

}

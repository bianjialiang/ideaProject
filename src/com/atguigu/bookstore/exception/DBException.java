package com.atguigu.bookstore.exception;

/**
 * @author Administrator
 * @create 2018-09-10 9:20
 **/
public class DBException extends RuntimeException {

    private static final long serialVersionId = 1L;

    public DBException() {

    }

    public DBException(String msg) {
        super(msg);
    }

    public DBException(String msg, Exception ex) {
        super(msg, ex);
    }


}

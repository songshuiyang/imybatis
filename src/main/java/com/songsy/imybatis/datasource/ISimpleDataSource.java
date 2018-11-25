package com.songsy.imybatis.datasource;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;

/**
 * @author songsy
 * @Date 2018/11/23 16:40
 */
public class ISimpleDataSource implements DataSource {

    private static String dirverClassName;
    private static String url;
    private static String username;
    private static String password;

    private int initConnections = 3;
    // 连接池
    private static LinkedList<Connection> pool = new LinkedList<>();

    public ISimpleDataSource(String dirverClassName, String url, String username, String password) {
        this.dirverClassName = dirverClassName;
        this.url = url;
        this.username = username;
        this.password = password;
        try {
            Class.forName(dirverClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取一个数据库连接
     *
     * @return 一个数据库连接
     * @throws SQLException
     */
    public Connection getConnection() throws SQLException {
        synchronized (pool) {
            if (pool.size() > 0) {
                return pool.removeFirst();
            } else return makeConnection();
        }
    }

    /**
     * 连接归池
     *
     * @param conn
     */
    public static void freeConnection(Connection conn) {
        pool.addLast(conn);
    }

    private Connection makeConnection() throws SQLException {
        for (int i = 0; i < initConnections; i++) {
            pool.add(DriverManager.getConnection(url, username, password));
        }
        return pool.removeFirst();
    }

    public Connection getConnection(String username, String password) throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    public void setLoginTimeout(int seconds) throws SQLException {

    }

    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}

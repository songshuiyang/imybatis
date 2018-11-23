package com.songsy.imybatis.session.defaults;

import com.songsy.imybatis.config.IConfiguration;
import com.songsy.imybatis.executor.IExecutor;
import com.songsy.imybatis.session.ISqlSession;

import java.sql.Connection;

/**
 * SqlSession默认实现
 * @author songsy
 * @Date 2018/11/19 19:20
 */
public class IDefaultISqlSession implements ISqlSession {

    private IConfiguration configuration;
    private IExecutor executor;

    public IDefaultISqlSession(IConfiguration configuration, IExecutor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    @Override
    public <T> T selectOne(String statement) {
        return null;
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return null;
    }

    @Override
    public Connection getConnection() {
        return null;
    }
}

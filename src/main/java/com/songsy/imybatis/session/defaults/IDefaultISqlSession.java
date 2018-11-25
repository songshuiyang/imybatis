package com.songsy.imybatis.session.defaults;

import com.songsy.imybatis.binding.IMapperRegistry;
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
    public <T> T selectOne(IMapperRegistry.MapperData mapperData, Object parameter) {
        return executor.doQuery(mapperData, parameter);
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        // 最后会去调用MapperRegistry.getMapper
        return configuration.<T>getMapper(this, type);
    }

    @Override
    public Connection getConnection() {
        return null;
    }

    @Override
    public IConfiguration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(IConfiguration configuration) {
        this.configuration = configuration;
    }

    public IExecutor getExecutor() {
        return executor;
    }

    public void setExecutor(IExecutor executor) {
        this.executor = executor;
    }
}

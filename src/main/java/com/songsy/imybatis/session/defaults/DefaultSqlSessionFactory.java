package com.songsy.imybatis.session.defaults;

import com.songsy.imybatis.config.Configuration;
import com.songsy.imybatis.session.SqlSession;
import com.songsy.imybatis.session.SqlSessionFactory;

/**
 * SqlSessionFactory 默认实现
 * 工厂模式
 * @author songsy
 * @Date 2018/11/19 19:20
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        return null;
    }
}

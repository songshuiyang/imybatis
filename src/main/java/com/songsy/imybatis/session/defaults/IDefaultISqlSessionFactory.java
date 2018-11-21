package com.songsy.imybatis.session.defaults;

import com.songsy.imybatis.config.IConfiguration;
import com.songsy.imybatis.session.ISqlSession;
import com.songsy.imybatis.session.ISqlSessionFactory;

/**
 * ISqlSessionFactory 默认实现
 * 工厂模式
 * @author songsy
 * @Date 2018/11/19 19:20
 */
public class IDefaultISqlSessionFactory implements ISqlSessionFactory {

    private final IConfiguration IConfiguration;

    public IDefaultISqlSessionFactory(IConfiguration IConfiguration) {
        this.IConfiguration = IConfiguration;
    }

    @Override
    public ISqlSession openSession() {
        return null;
    }
}

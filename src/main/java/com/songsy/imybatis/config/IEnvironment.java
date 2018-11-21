package com.songsy.imybatis.config;

import javax.sql.DataSource;

/**
 * 环境决定加载哪种环境(开发环境/生产环境)
 * @author songsy
 * @Date 2018/11/20 18:26
 */
public final class IEnvironment {
    // 环境id
    private final String id;

    // 事务工厂
    // private final TransactionFactory transactionFactory;

    // 数据源
    private final DataSource dataSource;

    public IEnvironment(String id, DataSource dataSource) {
        this.id = id;
        this.dataSource = dataSource;
    }
}

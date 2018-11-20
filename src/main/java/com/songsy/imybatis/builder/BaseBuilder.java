package com.songsy.imybatis.builder;

import com.songsy.imybatis.config.Configuration;

/**
 * 构建器的基类, 抽象共用属性
 * 建造者模式
 * @author songsy
 * @Date 2018/11/20 17:07
 */
public abstract class BaseBuilder {

    protected final Configuration configuration;

    public BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
    }

    public Configuration getConfiguration() {
        return configuration;
    }
}

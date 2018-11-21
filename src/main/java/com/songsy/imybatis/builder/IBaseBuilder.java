package com.songsy.imybatis.builder;

import com.songsy.imybatis.config.IConfiguration;

/**
 * 构建器的基类, 抽象共用属性
 * 建造者模式
 * @author songsy
 * @Date 2018/11/20 17:07
 */
public abstract class IBaseBuilder {

    protected final IConfiguration IConfiguration;

    public IBaseBuilder(IConfiguration IConfiguration) {
        this.IConfiguration = IConfiguration;
    }

    public IConfiguration getIConfiguration() {
        return IConfiguration;
    }
}

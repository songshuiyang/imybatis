package com.songsy.imybatis.executor;

import com.songsy.imybatis.config.IConfiguration;

import javax.security.auth.login.Configuration;

/**
 * @author songshuiyang
 * @date 2018/11/25 10:31
 */
public abstract class IBaseExecutor implements IExecutor{

    protected IConfiguration configuration;

    public IBaseExecutor(IConfiguration configuration) {
        this.configuration = configuration;
    }

    public IConfiguration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(IConfiguration configuration) {
        this.configuration = configuration;
    }
}

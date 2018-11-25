package com.songsy.imybatis.executor;

import com.songsy.imybatis.config.IConfiguration;

import javax.security.auth.login.Configuration;

/**
 * @author songshuiyang
 * @date 2018/11/25 10:31
 */
public abstract class BaseExecutor implements IExecutor{

    protected IConfiguration configuration;

    public BaseExecutor(IConfiguration configuration) {
        this.configuration = configuration;
    }

    public IConfiguration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(IConfiguration configuration) {
        this.configuration = configuration;
    }
}

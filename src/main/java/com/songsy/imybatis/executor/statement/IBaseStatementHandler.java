package com.songsy.imybatis.executor.statement;

import com.songsy.imybatis.config.IConfiguration;
import com.songsy.imybatis.executor.parameter.IDefaultParameterHandler;
import com.songsy.imybatis.executor.result.IDefaultResultSetHandler;

/**
 * @author songshuiyang
 * @date 2018/11/25 10:36
 */
public class IBaseStatementHandler {

    protected IConfiguration configuration;

    protected final IDefaultParameterHandler parameterHandler;

    protected final IDefaultResultSetHandler resultSetHandler;

    public IBaseStatementHandler(IConfiguration configuration) {
        this.configuration = configuration;
        this.parameterHandler = this.configuration.newParameterHandler();
        this.resultSetHandler = this.configuration.newResultSetHandler();
    }

    public IConfiguration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(IConfiguration configuration) {
        this.configuration = configuration;
    }

    public IDefaultParameterHandler getParameterHandler() {
        return parameterHandler;
    }

    public IDefaultResultSetHandler getResultSetHandler() {
        return resultSetHandler;
    }
}

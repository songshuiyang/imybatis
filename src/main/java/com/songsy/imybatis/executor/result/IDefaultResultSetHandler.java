package com.songsy.imybatis.executor.result;

import com.songsy.imybatis.config.IConfiguration;

import javax.security.auth.login.Configuration;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * sql 执行结果类
 * @author songshuiyang
 * @date 2018/11/25 10:19
 */
public class IDefaultResultSetHandler implements IResultSetHandler{
    private IConfiguration configuration;

    public IDefaultResultSetHandler(IConfiguration configuration) {
        this.configuration = configuration;
    }

    public IConfiguration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(IConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <E> List<E> handleResultSets(Statement stmt) throws SQLException {
        return null;
    }

    @Override
    public void handleOutputParameters(CallableStatement cs) throws SQLException {

    }
}

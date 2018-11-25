package com.songsy.imybatis.executor.parameter;

import com.songsy.imybatis.config.IConfiguration;

import javax.security.auth.login.Configuration;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * sql 参数处理类
 * @author songshuiyang
 * @date 2018/11/25 10:40
 */
public class IDefaultParameterHandler implements ParameterHandler{
    private IConfiguration configuration;

    public IDefaultParameterHandler(IConfiguration configuration) {
        this.configuration = configuration;
    }

    public IConfiguration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(IConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public Object getParameterObject() {
        return null;
    }

    @Override
    public void setParameters(PreparedStatement ps) throws SQLException {

    }
}

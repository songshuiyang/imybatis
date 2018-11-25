package com.songsy.imybatis.session;

import com.songsy.imybatis.binding.IMapperRegistry;
import com.songsy.imybatis.config.IConfiguration;

import javax.security.auth.login.Configuration;
import java.sql.Connection;

/**
 * 核心接口
 * @author songsy
 * @Date 2018/11/19 18:59
 */
public interface ISqlSession {

    <T> T selectOne(IMapperRegistry.MapperData mapperData, Object parameter);

    <T> T getMapper(Class<T> type);

    Connection getConnection();

    IConfiguration getConfiguration();


}

package com.songsy.imybatis.session;

import java.sql.Connection;

/**
 * 核心接口
 * @author songsy
 * @Date 2018/11/19 18:59
 */
public interface ISqlSession {

    <T> T selectOne(String statement);

    <T> T getMapper(Class<T> type);

    Connection getConnection();
}

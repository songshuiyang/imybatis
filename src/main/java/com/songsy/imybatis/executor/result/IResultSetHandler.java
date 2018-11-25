package com.songsy.imybatis.executor.result;

import com.songsy.imybatis.binding.IMapperRegistry;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @author songshuiyang
 * @date 2018/11/25 10:51
 */
public interface IResultSetHandler {
    /**
     * 处理结果集
     * @param stmt
     * @param <E>
     * @return
     * @throws SQLException
     */
    <E> E handleResultSets(Statement stmt, IMapperRegistry.MapperData mapperData) throws SQLException;
    /**
     * 处理OUT参数
     * @param cs
     * @throws SQLException
     */
    void handleOutputParameters(CallableStatement cs) throws SQLException;
}

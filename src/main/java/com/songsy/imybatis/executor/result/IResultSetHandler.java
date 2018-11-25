package com.songsy.imybatis.executor.result;

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
    <E> List<E> handleResultSets(Statement stmt) throws SQLException;
    /**
     * 处理OUT参数
     * @param cs
     * @throws SQLException
     */
    void handleOutputParameters(CallableStatement cs) throws SQLException;
}

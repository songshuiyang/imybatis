package com.songsy.imybatis.executor.parameter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author songshuiyang
 * @date 2018/11/25 10:48
 */
public interface ParameterHandler {
    /**
     * 得到参数
     * @return
     */
    Object getParameterObject();
    /**
     * 设置参数
     * @param ps
     * @throws SQLException
     */
    void setParameters(PreparedStatement ps)
            throws SQLException;

}

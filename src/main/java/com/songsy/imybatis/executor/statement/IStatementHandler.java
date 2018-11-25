package com.songsy.imybatis.executor.statement;

import com.songsy.imybatis.binding.IMapperRegistry;
import com.songsy.imybatis.config.IConfiguration;
import com.songsy.imybatis.config.IEnvironment;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 数据库操作和结果处理分发
 * @author songshuiyang
 * @date 2018/11/25 10:18
 */
public class IStatementHandler extends IBaseStatementHandler{

    public IStatementHandler(IConfiguration configuration) {
        super(configuration);
    }

    public <E> E query (IMapperRegistry.MapperData mapperData, Object parameter) {
        try {
            IEnvironment iEnvironment = configuration.getIEnvironment();
            DataSource dataSource = iEnvironment.getDataSource();
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(String.format(mapperData.getSql(), Integer.parseInt(String.valueOf(parameter))));
            // TODO 参数处理
            parameterHandler.setParameters(pstmt);
            pstmt.execute();
            // TODO 结果处理
            return resultSetHandler.handleResultSets(pstmt, mapperData);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

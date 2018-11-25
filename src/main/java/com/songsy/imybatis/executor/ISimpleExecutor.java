package com.songsy.imybatis.executor;

import com.songsy.imybatis.binding.IMapperRegistry;
import com.songsy.imybatis.config.IConfiguration;
import com.songsy.imybatis.executor.statement.IStatementHandler;

/**
 * 简单执行器
 * @author songshuiyang
 * @date 2018/11/25 10:07
 */
public class ISimpleExecutor extends IBaseExecutor {

    public ISimpleExecutor(IConfiguration configuration) {
        super(configuration);
    }

    @Override
    public <T> T doQuery(IMapperRegistry.MapperData mapperData, Object parameter) {
        IStatementHandler handler = configuration.newStatementHandler();
        return handler.query(mapperData, parameter);
    }
}

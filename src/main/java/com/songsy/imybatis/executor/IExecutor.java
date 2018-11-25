package com.songsy.imybatis.executor;

import com.songsy.imybatis.binding.IMapperRegistry;

/**
 * sql执行接口
 * @author songsy
 * @Date 2018/11/19 19:00
 */
public interface IExecutor {

    <T> T doQuery(IMapperRegistry.MapperData mapperData, Object parameter);

}

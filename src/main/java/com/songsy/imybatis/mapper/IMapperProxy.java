package com.songsy.imybatis.mapper;

import com.songsy.imybatis.binding.IMapperRegistry;
import com.songsy.imybatis.session.ISqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 映射器代理，代理模式
 * @author songsy
 * @Date 2018/11/19 19:04
 */
public class IMapperProxy<T> implements InvocationHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final ISqlSession sqlSession;

    private final Class<T> mappperInterface;

    public IMapperProxy(ISqlSession sqlSession, Class<T> clazz) {
        this.sqlSession = sqlSession;
        this.mappperInterface = clazz;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 得到sql映射数据
        String methodNamespace = method.getDeclaringClass().getName() + "." + method.getName();
        IMapperRegistry iMapperRegistry = sqlSession.getConfiguration().getiMapperRegistry();
        IMapperRegistry.MapperData mapperData = iMapperRegistry.getKnownMappers().get(methodNamespace);
        if (mapperData != null) {
            logger.info("SQL: {}, parameter: {}", mapperData.getSql(), args[0]);
            return sqlSession.selectOne(mapperData, String.valueOf(args[0]));
        }
        return null;
    }
}

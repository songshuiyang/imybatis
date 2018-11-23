package com.songsy.imybatis.binding;

import com.songsy.imybatis.exception.IPersistenceException;

import java.util.HashMap;
import java.util.Map;

/**
 * Mapper映射处理类
 * @author songsy
 * @Date 2018/11/19 19:26
 */
public class IMapperRegistry {

    /**
     * 存放mapper方法与sql的映射关系
     */
    public static final Map<String, MapperData> knownMappers = new HashMap<>();

    public class MapperData<T> {
        // 返回值类型
        private Class<T> resultType;
        // sql
        private String sql;

        public MapperData(Class<T> resultType, String sql) {
            this.sql = sql;
            this.resultType = resultType;
        }

        public Class<T> getResultType() {
            return resultType;
        }

        public void setResultType(Class<T> resultType) {
            this.resultType = resultType;
        }

        public String getSql() {
            return sql;
        }

        public void setSql(String sql) {
            this.sql = sql;
        }
    }

    public static Map<String, MapperData> getKnownMappers() {
        return knownMappers;
    }

    /**
     * 添加mapper
     * @param methodNamespace
     * @param <T>
     */
    public <T> void addMapper(String methodNamespace, String sql, Class<T> resultType) {
        MapperData mapperData = new MapperData(resultType, sql);
        if (knownMappers.get(methodNamespace) != null) {
            throw new IPersistenceException(methodNamespace + "mapper is exist");
        }
        knownMappers.put(methodNamespace, mapperData);
    }


}

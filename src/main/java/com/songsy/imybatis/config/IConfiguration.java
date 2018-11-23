package com.songsy.imybatis.config;

import com.songsy.imybatis.binding.IMapperRegistry;

import java.util.Properties;

/**
 * @author songsy
 * @Date 2018/11/19 19:13
 */
public class IConfiguration {
    // 环境
    protected IEnvironment IEnvironment;
    // 属性文件
    protected Properties variables = new Properties();
    //
    protected IMapperRegistry iMapperRegistry = new IMapperRegistry();


    public Properties getVariables() {
        return variables;
    }

    public void setVariables(Properties variables) {
        this.variables = variables;
    }

    public com.songsy.imybatis.config.IEnvironment getIEnvironment() {
        return IEnvironment;
    }

    public void setIEnvironment(com.songsy.imybatis.config.IEnvironment IEnvironment) {
        this.IEnvironment = IEnvironment;
    }

    /**
     * 添加mapper
     * @param methodNamespace
     * @param <T>
     */
    public <T> void addMapper(String methodNamespace, String sql, Class<T> resultType) {
        iMapperRegistry.addMapper(methodNamespace, sql, resultType);
    }


}

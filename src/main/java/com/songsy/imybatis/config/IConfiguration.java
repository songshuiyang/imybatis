package com.songsy.imybatis.config;

import com.songsy.imybatis.binding.IMapperRegistry;
import com.songsy.imybatis.executor.IExecutor;
import com.songsy.imybatis.executor.ISimpleExecutor;
import com.songsy.imybatis.executor.parameter.IDefaultParameterHandler;
import com.songsy.imybatis.executor.result.IDefaultResultSetHandler;
import com.songsy.imybatis.executor.statement.IStatementHandler;

import java.util.Properties;

/**
 * @author songsy
 * @Date 2018/11/19 19:13
 */
public class IConfiguration {
    /**
     * 环境
     */
    protected IEnvironment IEnvironment;
    /**
     * 属性文件
     */
    protected Properties variables = new Properties();
    //
    /**
     * mapper注册类
     */
    protected IMapperRegistry iMapperRegistry = new IMapperRegistry();
    //
    /**
     * 默认为简单执行器
     */
    protected ExecutorType defaultExecutorType = ExecutorType.SIMPLE;


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

    /**
     * 构建Executer
     * @return
     */
    public IExecutor newIExecutor (ExecutorType executorType) {
        IExecutor iExecutor = null;
        if (executorType == defaultExecutorType) {
            iExecutor = new ISimpleExecutor(this);
        }
        return iExecutor;
    }

    /**
     * 构建语句处理器
     * @return
     */
    public IStatementHandler newStatementHandler() {
        return new IStatementHandler(this);
    }

    /**
     * 构建参数处理器
     * @return
     */
    public IDefaultParameterHandler newParameterHandler() {
        return new IDefaultParameterHandler(this);
    }

    /**
     * 构建结果处理器
     * @return
     */
    public IDefaultResultSetHandler newResultSetHandler() {
        return new IDefaultResultSetHandler(this);
    }


}

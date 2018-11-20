package com.songsy.imybatis.config;

import java.util.Properties;

/**
 * @author songsy
 * @Date 2018/11/19 19:13
 */
public class Configuration {
    // 环境
    protected Environment environment;
    // 属性文件
    protected Properties variables = new Properties();

    public Properties getVariables() {
        return variables;
    }

    public void setVariables(Properties variables) {
        this.variables = variables;
    }
}

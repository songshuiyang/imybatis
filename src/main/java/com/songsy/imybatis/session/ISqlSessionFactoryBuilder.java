package com.songsy.imybatis.session;

import com.songsy.imybatis.builder.xml.IXMLConfigBuilder;
import com.songsy.imybatis.config.IConfiguration;
import com.songsy.imybatis.session.defaults.IDefaultISqlSessionFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * ISqlSessionFactory 构造器
 * @author songsy
 * @Date 2018/11/19 19:07
 */
public class ISqlSessionFactoryBuilder {

    public ISqlSessionFactory build(InputStream inputStream) {
        return build(inputStream, null, null);
    }

    public ISqlSessionFactory build(InputStream inputStream, String environment, Properties properties) {
        IXMLConfigBuilder parser = new IXMLConfigBuilder(inputStream, environment, properties);
        IConfiguration IConfiguration = parser.parse();
        return build(IConfiguration);
    }

    /**
     * 最后一个build方法使用了一个Configuration作为参数,并返回DefaultSqlSessionFactory
     *
     * @param config
     * @return
     */
    public ISqlSessionFactory build(IConfiguration config) {
        return new IDefaultISqlSessionFactory(config);
    }
}

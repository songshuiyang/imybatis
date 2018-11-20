package com.songsy.imybatis.session;

import com.songsy.imybatis.builder.xml.XMLConfigBuilder;
import com.songsy.imybatis.config.Configuration;
import com.songsy.imybatis.session.defaults.DefaultSqlSessionFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * SqlSessionFactory 构造器
 * @author songsy
 * @Date 2018/11/19 19:07
 */
public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(InputStream inputStream) {
        return build(inputStream, null, null);
    }

    public SqlSessionFactory build(InputStream inputStream, String environment, Properties properties) {
        XMLConfigBuilder parser = new XMLConfigBuilder(inputStream, environment, properties);
        Configuration configuration = parser.parse();
        return build(configuration);
    }

    /**
     * 最后一个build方法使用了一个Configuration作为参数,并返回DefaultSqlSessionFactory
     *
     * @param config
     * @return
     */
    public SqlSessionFactory build(Configuration config) {
        return new DefaultSqlSessionFactory(config);
    }

    public static void main(String[] args) throws Exception {
        File file = new File("src/test/resources/mybatis-config.xml");
        InputStream inputStream = new FileInputStream(file);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }
}

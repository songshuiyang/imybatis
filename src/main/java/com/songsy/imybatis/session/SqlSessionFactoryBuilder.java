package com.songsy.imybatis.session;

import java.io.InputStream;
import java.util.Properties;

/**
 * @author songsy
 * @Date 2018/11/19 19:07
 */
public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(InputStream inputStream) {
        return build(inputStream, null, null) ;
    }

    public SqlSessionFactory build(InputStream inputStream, String environment, Properties properties) {
        return null ;
    }
}

package com.songsy.imybatis.test.session;

import com.alibaba.druid.sql.dialect.sqlserver.visitor.SQLServerOutputVisitor;
import com.songsy.imybatis.session.ISqlSession;
import com.songsy.imybatis.session.ISqlSessionFactory;
import com.songsy.imybatis.session.ISqlSessionFactoryBuilder;
import com.songsy.imybatis.test.mapper.UserMapper;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author songsy
 * @Date 2018/11/20 17:55
 */
public class SqlSessionFactoryBuilderTest {

    @Test
    public void core() throws Exception {
        File file = new File("src/test/resources/mybatis-config.xml");
        InputStream inputStream = new FileInputStream(file);
        ISqlSessionFactory ISqlSessionFactory = new ISqlSessionFactoryBuilder().build(inputStream);
        ISqlSession iSqlSession = ISqlSessionFactory.openSession();
        UserMapper userMapper = iSqlSession.getMapper(UserMapper.class);
        System.out.println(userMapper.selectByPrimaryKey("1"));
    }
}

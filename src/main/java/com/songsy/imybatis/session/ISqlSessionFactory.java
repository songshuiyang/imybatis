package com.songsy.imybatis.session;

/**
 * 构建SqlSession的工厂
 * @author songsy
 * @Date 2018/11/19 19:06
 */
public interface ISqlSessionFactory {

    // 用来创建SqlSession实例
    ISqlSession openSession();

}

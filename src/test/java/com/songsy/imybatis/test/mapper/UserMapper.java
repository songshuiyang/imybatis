package com.songsy.imybatis.test.mapper;

import com.songsy.imybatis.test.entity.User;

/**
 * 用户
 * @author songshuiyang
 */
public interface UserMapper {
    User selectByPrimaryKey (String id);
}
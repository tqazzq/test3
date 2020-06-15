package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.Param;

/**
 * @Author Tian Qing
 * @Daate: Created in 19:56 2020/5/26
 */
public interface LoginDao {
    User findUser(@Param("username") String username,@Param("password") String password);
}

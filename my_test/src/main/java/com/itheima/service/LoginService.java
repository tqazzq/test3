package com.itheima.service;

import com.itheima.domain.User;

/**
 * @Author Tian Qing
 * @Daate: Created in 19:50 2020/5/26
 */
public interface LoginService {
    User findUser(String username, String password);
}

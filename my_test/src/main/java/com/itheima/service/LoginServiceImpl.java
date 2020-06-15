package com.itheima.service;

import com.itheima.dao.LoginDao;
import com.itheima.domain.User;
import com.itheima.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

/**
 * @Author Tian Qing
 * @Daate: Created in 19:50 2020/5/26
 */
public class LoginServiceImpl implements LoginService {
    @Override
    public User findUser(String username, String password) {
        //调用dao层查询
        SqlSession sqlSession = MyBatisUtils.openSession();
        LoginDao mapper = sqlSession.getMapper(LoginDao.class);
        User userResult = mapper.findUser(username,password);
        if (userResult == null){
            MyBatisUtils.close(sqlSession);
            userResult.setMsg("用户不存在");
            userResult.setB(false);
            return userResult;
        }
        if (!userResult.getPassword().equals(password)){
            MyBatisUtils.close(sqlSession);
            userResult.setMsg("密码错误");
            userResult.setB(false);
            return userResult;
        }else {
            MyBatisUtils.close(sqlSession);
            userResult.setB(true);
            userResult.setMsg("登录成功");
            return userResult;
        }
    }
}

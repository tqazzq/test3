package com.itheima.web.servlet;

import com.itheima.domain.User;
import com.itheima.service.LoginService;
import com.itheima.service.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author Tian Qing
 * @Daate: Created in 19:40 2020/5/26
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    LoginService loginService = new LoginServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User userResult = new User();
        //获取参数
        String username = request.getParameter("user");
        String password = request.getParameter("password");
        //非空判断
        if (username.length() == 0 || password.length() == 0) {
            request.setAttribute("result", false);
            request.getRequestDispatcher("/login.jsp");
        } else {
            //调用servicre查询
            userResult = loginService.findUser(username, password);
            request.setAttribute("result", userResult);
            request.getRequestDispatcher("login.jsp");
        }
    }
}



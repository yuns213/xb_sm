package com.zjj.controller;

import com.zjj.constants.SysConstant;
import com.zjj.entity.User;
import com.zjj.service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @auth yunsll
 * @date 2020/3/17 20:14
 * @Descripiton 测试类
 */

@WebServlet("/login/login")
public class LoginServlet extends HttpServlet {
    private LoginService loginService = new LoginService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            String name = req.getParameter("username");
            String password = req.getParameter("password");
            //前端输入的值
            String picCode = req.getParameter("picCode");
            //session 存放req对象的数据
            HttpSession session = req.getSession();
            //这个是通过getAttribute 获取 SysConstant.SESSION_PIC_CODE这个键得到值
            Object picObj =session.getAttribute(SysConstant.SESSION_PIC_CODE);
            if(picCode == null){
                resp.sendRedirect("/index.jsp");
                return;
            }
            if (!picObj.toString().equals(picCode)){
                System.out.println("验证码不正确");
                resp.sendRedirect("/index.jsp");
                return;
            }
            User  user = new User();
            user.setUsername(name);
            user.setPassword(password);

            User result = loginService.checkLogin(user);
            if (result == null){
                //重新登录
                resp.sendRedirect("index.jsp");
                return;
            }else{
                //登录成功.转跳到主页面
                req.getRequestDispatcher("/html/common/home.jsp").forward(req,resp);
                return;
            }

        }catch (Exception e){
            e.printStackTrace();
            resp.sendRedirect("/index.jsp");
            return;
        }
    }
}

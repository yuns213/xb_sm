package com.zjj.service;

import com.zjj.dao.LoginDao;
import com.zjj.entity.User;

/**
 * @auth yunsll
 * @date 2020/3/17 20:17
 * @Descripiton 测试类
 */
public class LoginService {
    private LoginDao loginDao = new LoginDao();

    public User checkLogin(User user){
        return  loginDao.checkLogin(user);
    }
}

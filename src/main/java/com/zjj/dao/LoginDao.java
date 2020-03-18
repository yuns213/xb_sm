package com.zjj.dao;

import com.zjj.entity.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

/**
 * @auth yunsll
 * @date 2020/3/17 18:57
 * @Descripiton 测试类
 */
public class LoginDao extends  BaseDao{

    public User checkLogin(User user){
        String sql = "select * from sys_user where username=? and password = ?";
        return template.queryForObject(sql,new BeanPropertyRowMapper<>(User.class),user.getUsername(),user.getPassword());



    }
}

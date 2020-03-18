package com.zjj.dao;

import com.zjj.entity.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.List;

/**
 * @auth yunsll
 * @date 2020/3/17 19:11
 * @Descripiton 测试类
 */
public class UserDao extends BaseDao {
    //
    public List<User> listAll(){
        String sql = "select * from sys_user ";
        return  template.query(sql,new BeanPropertyRowMapper<User>(User.class));
    }
}

package com.zjj.dao;

import com.zjj.utils.DBUtil;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @auth yunsll
 * @date 2020/3/17 19:10
 * @Descripiton 测试类
 */
public class BaseDao {
    public JdbcTemplate template = new JdbcTemplate(DBUtil.getDataSource());

}

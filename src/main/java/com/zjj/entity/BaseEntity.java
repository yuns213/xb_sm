package com.zjj.entity;

import java.io.Serializable;

/**
 * @auth yunsll
 * @date 2020/3/17 18:51
 * @Descripiton 测试类
 */
public class BaseEntity implements Serializable {

    public static final long  serialVersionUID =1561563135468L;
    //创建时间
    private String createTime;
    //创建人
    private int createBy;
    //是否删除 1是,0否
    private int delFlag;

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getCreateBy() {
        return createBy;
    }

    public void setCreateBy(int createBy) {
        this.createBy = createBy;
    }

    public int getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(int delFlag) {
        this.delFlag = delFlag;
    }
}

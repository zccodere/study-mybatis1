package com.zccoder.mybatis1.ch8.ssm.dao.po;

import java.io.Serializable;
import java.util.Date;

/**
 * 标题：表 t_user PO<br>
 * 描述：表 t_user PO<br>
 * 时间：2018/05/17<br>
 *
 * @author zc
 **/
public class UserPO implements Serializable {

    private static final long serialVersionUID = -3423954886546786851L;
    
    /**
     * 主键
     */
    private Integer id;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 生日
     */
    private Date birthday;
    /**
     * 性别
     */
    private String sex;
    /**
     * 手机
     */
    private String mobile;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 备注
     */
    private String note;

    @Override
    public String toString() {
        return "UserPO{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", note='" + note + '\'' +
                '}';
    }

    /**
     * 获取 主键
     *
     * @return id 主键
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * 设置 主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取 用户名称
     *
     * @return userName 用户名称
     */
    public String getUserName() {
        return this.userName;
    }

    /**
     * 设置 用户名称
     *
     * @param userName 用户名称
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取 生日
     *
     * @return birthday 生日
     */
    public Date getBirthday() {
        return this.birthday;
    }

    /**
     * 设置 生日
     *
     * @param birthday 生日
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取 性别
     *
     * @return sex 性别
     */
    public String getSex() {
        return this.sex;
    }

    /**
     * 设置 性别
     *
     * @param sex 性别
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 获取 手机
     *
     * @return mobile 手机
     */
    public String getMobile() {
        return this.mobile;
    }

    /**
     * 设置 手机
     *
     * @param mobile 手机
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取 邮箱
     *
     * @return email 邮箱
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * 设置 邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取 备注
     *
     * @return note 备注
     */
    public String getNote() {
        return this.note;
    }

    /**
     * 设置 备注
     *
     * @param note 备注
     */
    public void setNote(String note) {
        this.note = note;
    }
}

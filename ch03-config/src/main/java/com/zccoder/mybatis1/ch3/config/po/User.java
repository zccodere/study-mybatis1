package com.zccoder.mybatis1.ch3.config.po;

import com.zccoder.mybatis1.ch3.config.enums.Sex;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.Date;

/**
 * 标题：POJO类<br>
 * 描述：用户信息<br>
 *
 * @author zc
 * @date 2018/04/19
 **/
@Alias("user")
public class User implements Serializable {
    private static final long serialVersionUID = -4682594756461465431L;

    private Long id;
    /**
     * 名称
     */
    private String userName;
    /**
     * 中文名称
     */
    private String cnname;
    /**
     * 手机
     */
    private String mobile;
    /**
     * 性别
     */
    private Sex sex;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 备注
     */
    private String note;
    /**
     * 生日
     */
    private Date birthday;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", cnname='" + cnname + '\'' +
                ", mobile='" + mobile + '\'' +
                ", sex=" + sex +
                ", email='" + email + '\'' +
                ", note='" + note + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCnname() {
        return cnname;
    }

    public void setCnname(String cnname) {
        this.cnname = cnname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}

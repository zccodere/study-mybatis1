package com.zccoder.mybatis1.ch5.dynamic.po;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * 标题：角色类<br>
 * 描述：POJO<br>
 *
 * @author zc
 * @date 2018/04/25
 **/
@Alias("role")
public class Role implements Serializable {

    private static final long serialVersionUID = 7347474424837359046L;

    private Long id;
    private String roleName;
    private String note;

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", note='" + note + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}

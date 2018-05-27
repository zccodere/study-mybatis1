package com.zccoder.mybatis1.ch2.hello.po;

import java.io.Serializable;

/**
 * <br>
 * 标题：POJO<br>
 * 描述：角色PO类<br>
 *
 * @author zc
 * @date 2018/03/14
 **/
public class Role implements Serializable {

    private static final long serialVersionUID = 1552775552365198487L;
    /**
     * ID
     */
    private Long id;

    /**
     * 名称
     */
    private String roleName;

    /**
     * 备注
     */
    private String note;

    @Override
    public String toString() {
        return "Role{" +
                "id='" + id + '\'' +
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

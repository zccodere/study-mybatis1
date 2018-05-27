package com.zccoder.mybatis1.ch8.ssm.dao.po;

import java.io.Serializable;
import java.util.Date;

/**
 * 标题：表 t_role PO<br>
 * 描述：表 t_role PO<br>
 * 时间：2018/05/17<br>
 *
 * @author zc
 **/
public class RolePO implements Serializable {

    private static final long serialVersionUID = -5650546738695963728L;

    /**
     * 主键
     */
    private Integer id;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 备注
     */
    private String note;

    @Override
    public String toString() {
        return "RolePO{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", createDate=" + createDate +
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
     * 获取 角色名称
     *
     * @return roleName 角色名称
     */
    public String getRoleName() {
        return this.roleName;
    }

    /**
     * 设置 角色名称
     *
     * @param roleName 角色名称
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * 获取 创建时间
     *
     * @return createDate 创建时间
     */
    public Date getCreateDate() {
        return this.createDate;
    }

    /**
     * 设置 创建时间
     *
     * @param createDate 创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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

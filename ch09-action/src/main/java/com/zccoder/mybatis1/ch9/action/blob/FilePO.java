package com.zccoder.mybatis1.ch9.action.blob;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 标题：表 t_file PO<br>
 * 描述：表 t_file PO<br>
 * 时间：2018/05/24<br>
 *
 * @author zc
 **/
public class FilePO implements Serializable {

    private static final long serialVersionUID = 306231253910151896L;

    private Long id;

    private byte[] file;

    @Override
    public String toString() {
        return "FilePO{" +
                "id=" + id +
                ", file=" + Arrays.toString(file) +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }
}

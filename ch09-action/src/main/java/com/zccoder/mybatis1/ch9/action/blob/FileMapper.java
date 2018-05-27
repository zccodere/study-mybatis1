package com.zccoder.mybatis1.ch9.action.blob;

/**
 * 标题：表 t_file Mapper<br>
 * 描述：表 t_file Mapper<br>
 * 时间：2018/05/24<br>
 *
 * @author zc
 **/
public interface FileMapper {

    /**
     * 新增
     * @param filePO PO
     * @return 影响条数
     */
    int insert(FilePO filePO);

    /**
     * 查询
     * @param id ID
     * @return PO
     */
    FilePO findOne(Integer id);

}

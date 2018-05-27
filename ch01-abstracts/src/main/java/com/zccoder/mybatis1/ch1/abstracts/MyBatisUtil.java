package com.zccoder.mybatis1.ch1.abstracts;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * <br>
 * 标题：MyBatis 工具类<br>
 * 描述：建立 MyBatis 的工厂对象（SqlSessionFactory）<br>
 *
 * @author zc
 * @date 2018/03/14
 **/
public class MyBatisUtil {

    private static SqlSessionFactory sqlSessionFactory = null;

    public static SqlSessionFactory getSqlSessionFactory(){
        if (sqlSessionFactory == null){
            try {
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis.cfg.xml"));
                return sqlSessionFactory;
            } catch (IOException e) {
                System.err.println(e.getMessage());
                e.printStackTrace();
            }
        }
        return sqlSessionFactory;
    }
}

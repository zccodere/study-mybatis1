package com.zccoder.mybatis1.ch2.hello;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <br>
 * 标题：SqlSessionFactory 工具类<br>
 * 描述：使用单例模式构建 SqlSessionFactory 对象<br>
 *
 * @author zc
 * @date 2018/03/14
 **/
public class SqlSessionFactoryUtil {

    /**
     * SqlSessionFactory 对象
     */
    private static SqlSessionFactory sqlSessionFactory = null;

    /**
     * 类线程锁
     */
    private static final Class CLASS_LOCK = SqlSessionFactoryUtil.class;

    /**
     * 私有化无参构造方法
     */
    private SqlSessionFactoryUtil() {
    }

    public static SqlSessionFactory initSqlSessionFactory(){
        String resource = "mybatis.cfg.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            Logger.getLogger(SqlSessionFactoryUtil.class.getName()).log(Level.SEVERE,null,e);
        }
        synchronized (CLASS_LOCK){
            if (sqlSessionFactory == null){
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            }
        }
        return sqlSessionFactory;
    }

    public static SqlSession openSqlSession(){
        if (sqlSessionFactory == null){
            initSqlSessionFactory();
        }
        return sqlSessionFactory.openSession();
    }
}

package com.zccoder.mybatis1.ch3.config;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <br>
 * 标题：properties 元素<br>
 * 描述：通过程序参数传递演示<br>
 *
 * @author zc
 * @date 2018/03/15
 **/
public class PropertiesDemo {

    private static final Class CLASS_LOCK = PropertiesDemo.class;
    private static SqlSessionFactory sqlSessionFactory = null;

    private void init(){
        InputStream cfgStream = null;
        Reader cfgReader = null;
        InputStream proStream = null;
        Reader proReader = null;
        Properties properties = null;
        try {
            // 读入配置文件流
            cfgStream = Resources.getResourceAsStream("mybatis-properties.cfg.xml");
            cfgReader = new InputStreamReader(cfgStream);
            // 读入属性文件
            proStream = Resources.getResourceAsStream("jdbc.properties");
            proReader = new InputStreamReader(proStream);

            properties = new Properties();
            properties.load(proReader);
            // 解密为明文
            properties.setProperty("username",decode(properties.getProperty("username")));
            properties.setProperty("password",decode(properties.getProperty("password")));
        } catch (IOException e){
            Logger.getLogger(PropertiesDemo.class.getName()).log(Level.SEVERE,null,e);
        }
        synchronized (CLASS_LOCK){
            if (sqlSessionFactory == null){
                // 使用属性来创建 SqlSessionFactory
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(cfgReader,properties);
            }
        }
    }

    public SqlSessionFactory getSqlSessionFactory() {
        if (sqlSessionFactory == null){
            this.init();
        }
        return sqlSessionFactory;
    }

    private String decode(String value) {
        // 将加密后的值配置在属性文件中，这里进行解密
        return value;
    }
}

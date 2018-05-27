package com.zccoder.mybatis1.ch2.hello;

import com.zccoder.mybatis1.ch2.hello.mapper.RoleMapper;
import com.zccoder.mybatis1.ch2.hello.mapper.RoleMapperAnno;
import com.zccoder.mybatis1.ch2.hello.po.Role;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

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

    public static SqlSessionFactory getSqlSessionFactoryByXml(){
        SqlSessionFactory sqlSessionFactory = null;
        String resources = "mybatis.cfg.xml";
            try {
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(resources));
            } catch (IOException e) {
                System.err.println(e.getMessage());
                e.printStackTrace();
            }
        return sqlSessionFactory;
    }

    public static SqlSessionFactory getSqlSessionFactoryByConf(){
        // 构建数据库连接池
        PooledDataSource dataSource = new PooledDataSource();
        dataSource.setDriver("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/mybatis1?characterEncoding=utf8");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        // 构建数据库事务方式
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        // 创建数据库运行环境
        Environment environment = new Environment("dev",transactionFactory,dataSource);
        // 构建 Configuration 对象
        Configuration configuration = new Configuration(environment);
        // 注册别名
        configuration.getTypeAliasRegistry().registerAlias("role", Role.class);
        // 注册映射器
        configuration.addMapper(RoleMapper.class);
        configuration.addMapper(RoleMapperAnno.class);
        // 使用 SqlSessionFactoryBuilder 构建 SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        return sqlSessionFactory;
    }
}

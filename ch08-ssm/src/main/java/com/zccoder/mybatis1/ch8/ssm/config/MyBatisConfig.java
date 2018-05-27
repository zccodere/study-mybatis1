package com.zccoder.mybatis1.ch8.ssm.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * 标题：集成MyBatis<br>
 * 描述：MyBatis相关配置<br>
 * 时间：2018/05/17<br>
 * 使用 @EnableTransactionManagement // 开启自动事务控制
 *
 * @author zc
 **/
@Configuration
@EnableTransactionManagement
public class MyBatisConfig {

    @Autowired
    private Environment environment;

    @Bean
    public DataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(environment.getProperty("db.driver"));
        dataSource.setUrl(environment.getProperty("db.url"));
        dataSource.setUsername(environment.getProperty("db.username"));
        dataSource.setPassword(environment.getProperty("db.password"));
        return dataSource;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(){
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setConfigLocation(new ClassPathResource("mybatis.cfg.xml"));
        return factoryBean;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        // 扫描包下的所有 Mapper.java
        configurer.setBasePackage("com.zccoder.mybatis1.ch8.ssm.dao");
        configurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");
        configurer.setAnnotationClass(Repository.class);
        return configurer;
    }
}

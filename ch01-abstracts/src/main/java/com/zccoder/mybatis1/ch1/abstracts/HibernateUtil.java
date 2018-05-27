package com.zccoder.mybatis1.ch1.abstracts;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * <br>
 * 标题：Hibernate 工具类<br>
 * 描述：建立 Hibernate 的工厂对象（SessionFactory）<br>
 *
 * @author zc
 * @date 2018/03/14
 **/
public class HibernateUtil {

    private static SessionFactory sessionFactory;

    static {
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        sessionFactory = cfg.buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}

package com.zccoder.mybatis1.ch1.abstracts;

import com.zccoder.mybatis1.ch1.abstracts.po.Role;
import org.hibernate.Session;

/**
 * <br>
 * 标题：使用 Hibernate 编程<br>
 * 描述：使用 Hibernate 编程的例子<br>
 *
 * @author zc
 * @date 2018/03/14
 **/
public class HibernateExample {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Role role = session.get(Role.class,1L);
        System.out.println("role_name => " + role.getRoleName());
        session.close();
    }
}

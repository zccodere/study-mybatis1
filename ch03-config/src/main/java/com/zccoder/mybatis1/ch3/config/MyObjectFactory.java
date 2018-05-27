package com.zccoder.mybatis1.ch3.config;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Properties;

/**
 * 标题：自定义ObjectFactory<br>
 * 描述：继承DefaultObjectFactory来简化编程，大部分情况下，使用系统默认的即可<br>
 *
 * @author zc
 * @date 2018/04/19
 **/
public class MyObjectFactory extends DefaultObjectFactory{

    private static final long serialVersionUID = -6421137313378981965L;
    Logger log = Logger.getLogger(MyObjectFactory.class);

    @Override
    public <T> T create(Class<T> type) {
        log.info("使用定制对象工厂的create方法构建单个对象");
        return super.create(type);
    }

    @Override
    public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
        log.info("使用定制对象工厂的create方法构建列表对象");
        return super.create(type, constructorArgTypes, constructorArgs);
    }

    @Override
    public void setProperties(Properties properties) {
        log.info("使用定制对象工厂的setProperties方法设置属性");
        super.setProperties(properties);
    }

    @Override
    public <T> boolean isCollection(Class<T> type) {
        return super.isCollection(type);
    }
}

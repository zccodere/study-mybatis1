package com.zccoder.mybatis1.ch7.plugin;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;

import java.util.Properties;

/**
 * 标题：编写自定义插件<br>
 * 描述：拦截 StatementHandler 对象 的 prepare 方法<br>
 * 时间：2018/05/10<br>
 *
 * @author zc
 **/
@Intercepts({
    @Signature(
        // 确定要拦截的对象
        type = Executor.class,
        // 确定要拦截的方法
        method = "update",
        // 拦截方法的参数
        args = {MappedStatement.class,Object.class})
})
public class MyPlugin implements Interceptor {

    private Properties properties;

    /**
     * 代替拦截对方方法的内容
     * @param invocation 责任链对象
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.err.println("自定义插件 before...");
        Object obj = invocation.proceed();
        System.err.println("自定义插件 after...");
        return obj;
    }

    /**
     * 生成代理对象，这里常用MyBatis提供的Plugin类的wrap方法
     * @param target 被代理的对象
     */
    @Override
    public Object plugin(Object target) {
        // 使用MyBatis提供的Plugin类的wrap方法生成代理对象
        System.err.println("自定义插件 调用生成代理对象");
        return Plugin.wrap(target,this);
    }

    /**
     * 获取插件配置的属性，在MyBatis的配置文件中配置
     * @param properties 是MyBatis配置的参数
     */
    @Override
    public void setProperties(Properties properties) {
        System.err.println("自定义插件 " + properties.getProperty("dbType"));
        this.properties = properties;
    }
}

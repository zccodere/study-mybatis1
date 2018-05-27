package com.zccoder.mybatis1.ch7.plugin;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;

import java.sql.Connection;
import java.util.Properties;

/**
 * 标题：编写自定义插件<br>
 * 描述：拦截 StatementHandler 对象 的 prepare 方法<br>
 * 时间：2018/05/10<br>
 *
 * @author zc
 **/
@Intercepts({
        @Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class})
})
public class MyPluginDemo implements Interceptor {

    /**
     * 反射调用原来对象的方法
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        return null;
    }

    /**
     * 给被拦截对象生成一个代理对象，并返回它
     */
    @Override
    public Object plugin(Object target) {
        return null;
    }

    /**
     * 给插件配置参数
     */
    @Override
    public void setProperties(Properties properties) {

    }
}

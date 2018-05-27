package com.zccoder.mybatis1.ch6.core.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 标题：Hello 服务代理类<br>
 * 描述：需实现 InvocationHandler 接口<br>
 *
 * @author zc
 * @date 2018/04/26
 **/
public class HelloServiceProxy implements InvocationHandler {

    /**
     * 真实服务对象
     */
    private Object target;

    /**
     * 绑定委托对象并返回一个代理对象
     * @param target 真实服务对象
     * @return 代理对象
     */
    public Object bind(Object target){
        this.target = target;
        // 取得代理对象 jdk 动态代理需要提供接口
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    /**
     * 通过代理对象调用方法首先会进入这个方法
     * @param proxy 代理对象
     * @param method 被调用方法
     * @param args 方法的参数
     * @return 方法返回值
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.err.println("##### 我是 jdk 动态代理 #####");
        Object result = null;
        // 反射调用方法前
        System.err.println("##### 我准备说 hello ");
        // 执行方法，相当于 HelloServiceImpl 类的 sayHello 方法
        result = method.invoke(target,args);
        // 反射调用方法后
        System.err.println("##### 我说完了 hello");
        return result;
    }
}

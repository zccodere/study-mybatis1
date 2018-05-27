package com.zccoder.mybatis1.ch6.core.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 标题：Hello 服务代理类<br>
 * 描述：使用 cglib <br>
 *
 * @author zc
 * @date 2018/04/26
 **/
public class HelloServiceCglib implements MethodInterceptor {

    /**
     * 真实对象
     */
    private Object target;

    /**
     * 创建代理对象
     * @param target 真实对象
     * @return 代理对象
     */
    public Object getInstance(Object target){
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        // 回调方法
        enhancer.setCallback(this);
        // 创建代理对象
        return enhancer.create();
    }

    /**
     * 回调方法
     */
    @Override
    public Object intercept(Object target, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.err.println("##### 我是 cglib 动态代理 #####");
        // 反射调用方法前
        System.err.println("##### 我准备说 hello ");
        // 执行方法，相当于 HelloServiceImpl 类的 sayHello 方法
        Object result = proxy.invokeSuper(target,args);
        // 反射调用方法后
        System.err.println("##### 我说完了 hello");
        return result;
    }
}

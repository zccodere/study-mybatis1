package com.zccoder.mybatis1.ch6.core.proxy;

import com.zccoder.mybatis1.ch6.core.proxy.HelloService;
import com.zccoder.mybatis1.ch6.core.proxy.HelloServiceImpl;
import com.zccoder.mybatis1.ch6.core.proxy.cglib.HelloServiceCglib;
import com.zccoder.mybatis1.ch6.core.proxy.jdk.HelloServiceProxy;

/**
 * 标题：启动类<br>
 * 描述：演示 jdk 动态代理<br>
 *
 * @author zc
 * @date 2018/04/26
 **/
public class HelloServiceMain {

    public static void main(String[] args) {
        HelloServiceProxy helloHandler = new HelloServiceProxy();
        HelloService proxy1 = (HelloService) helloHandler.bind(new HelloServiceImpl());
        proxy1.sayHello("张三");

        HelloServiceCglib helloCglib = new HelloServiceCglib();
        HelloService proxy2 = (HelloService) helloCglib.getInstance(new HelloServiceImpl());
        proxy2.sayHello("李四");
    }
}

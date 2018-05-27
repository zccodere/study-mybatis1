package com.zccoder.mybatis1.ch6.core.proxy;

/**
 * 标题：Hello 服务实现类<br>
 * 描述：默认实现类<br>
 *
 * @author zc
 * @date 2018/04/26
 **/
public class HelloServiceImpl implements HelloService {

    @Override
    public void sayHello(String name) {
        System.err.println("hello " + name);
    }
}

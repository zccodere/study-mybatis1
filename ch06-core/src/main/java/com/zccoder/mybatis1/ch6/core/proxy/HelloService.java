package com.zccoder.mybatis1.ch6.core.proxy;

/**
 * 标题：Hello 服务<br>
 * 描述：被代理的服务接口<br>
 *
 * @author zc
 * @date 2018/04/26
 **/
public interface HelloService {

    /**
     * 打印 Hello
     * @param name 名称
     */
    void sayHello(String name);

}

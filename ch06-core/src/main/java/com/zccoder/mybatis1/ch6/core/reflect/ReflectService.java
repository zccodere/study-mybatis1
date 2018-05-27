package com.zccoder.mybatis1.ch6.core.reflect;

import java.lang.reflect.Method;

/**
 * 标题：使用反射技术<br>
 * 描述：使用反射调用方法<br>
 *
 * @author zc
 * @date 2018/04/26
 **/
public class ReflectService {

    /**
     * 测试入口
     *
     * @param args 参数
     */
    public static void main(String[] args)throws Exception {

        // 通过反射创建 ReflectService 对象
        Object service = Class.forName(ReflectService.class.getName()).newInstance();
        // 获取服务方法 sayHello
        Method method = service.getClass().getMethod("sayHello",String.class);
        // 反射调用方法
        method.invoke(service,"harry");
    }

    /**
     * 服务方法
     *
     * @param name 名称
     */
    public void sayHello(String name) {
        System.out.println("hello " + name);
    }

}

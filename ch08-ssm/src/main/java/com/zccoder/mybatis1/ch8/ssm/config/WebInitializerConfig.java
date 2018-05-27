package com.zccoder.mybatis1.ch8.ssm.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.*;
import java.util.EnumSet;

/**
 * 标题：Web项目启动类<br>
 * 描述：Web项目启动类<br>
 * 时间：2018/05/17<br>
 *
 * @author zc
 **/
public class WebInitializerConfig implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(SpringMvcConfig.class);

        // 新建WebApplication，注册配置类，并将其和当前servletContext关联。
        context.setServletContext(servletContext);

        // 注册SpringMVC的DispatcherServlet。
        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(context));
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);

        // 注册SpringMVC的字符过滤器
        FilterRegistration.Dynamic encodingFilter = servletContext.addFilter("encoding", new CharacterEncodingFilter());
        EnumSet<DispatcherType> dispatcherTypes = EnumSet.allOf(DispatcherType.class);
        dispatcherTypes.add(DispatcherType.REQUEST);
        dispatcherTypes.add(DispatcherType.FORWARD);
        dispatcherTypes.add(DispatcherType.ERROR);
        dispatcherTypes.add(DispatcherType.ASYNC);
        dispatcherTypes.add(DispatcherType.INCLUDE);
        encodingFilter.addMappingForUrlPatterns(dispatcherTypes, true, "/*");
        encodingFilter.setInitParameter("encoding", "UTF-8");
    }
}

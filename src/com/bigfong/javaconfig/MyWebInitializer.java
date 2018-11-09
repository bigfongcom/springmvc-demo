package com.bigfong.javaconfig;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration.Dynamic;
import javax.servlet.ServletContext;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/***********************************************************************
 * Web容器启动
 * 
 * @author bigfong
 * @create-time 2018年11月9日 下午2:25:33
 * @revision $Id: 1.0
 * 
 ***********************************************************************/

public class MyWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    // 根容器
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { RootConfig.class };
    }

    // SpringMVC容器
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { WebConfig.class };
    }

    // 映射路径
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    protected void registerContextLoaderListener(ServletContext servletContext) {
        super.registerContextLoaderListener(servletContext);
        // 编码过滤器
        Dynamic filter = servletContext.addFilter("CharacterEncodingFilter", CharacterEncodingFilter.class);
        filter.setInitParameter("encoding", "UTF-8");
        filter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
    }

}

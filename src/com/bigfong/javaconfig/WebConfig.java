package com.bigfong.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.bigfong.javaconfig.interceptor.CheckLoginInterceptor;

/***********************************************************************   
*
* @author        bigfong
* @create-time   2018年11月9日 下午2:33:42
* @revision      $Id: 1.0  
*   
***********************************************************************/

@Configuration
@EnableWebMvc
@ComponentScan("com.bigfong.javaconfig")
public class WebConfig implements WebMvcConfigurer{

    @Bean
    public CheckLoginInterceptor checkLoginInterceptor() {
            return new CheckLoginInterceptor();
    }

    //配置拦截器
    public void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor(checkLoginInterceptor())//
                            .addPathPatterns("/**")//
                            .excludePathPatterns("/login");

    }

    //配置JSP视图
    @Bean
    public ViewResolver viewResolver() {
            InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
            viewResolver.setPrefix("/WEB-INF/views/");
            viewResolver.setSuffix(".jsp");
            return viewResolver;
    }

    //配置静态资源处理
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
            configurer.enable();
    }
}

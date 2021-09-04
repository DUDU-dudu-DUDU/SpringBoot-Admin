package com.wu.admin.config;

import com.wu.admin.interceptor.LoginInterceptor;
import com.wu.admin.interceptor.RedisUrlCountInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
* 1.编写一个拦截器实现HandlerInterceptor接口
* 2.拦截器注册到容器中（实现WebMvcConfigurer和addInterceptors）在配置中加上@Controller
* 3.指定拦截规则（放行静态页面和资源）
* */

@Controller
public class AdminWebConfig implements WebMvcConfigurer {

    /*
    * Filter. Interceptor 几乎拥有相同的功能?
    * 1、Filter 是Servlet定义的原生组件。好处，脱离Spring应用也能使用
    * 2、Interceptor是Spring定义的接口。可以使用spring的自动装配等功能
    * */
    @Autowired
    RedisUrlCountInterceptor redisUrlCountInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**") // 所有请求都被拦截包括静态资源
                .excludePathPatterns("/", "/login", "/css/**", "/js/**", "/fonts/**","/images/**");// "/sql"

        registry.addInterceptor(redisUrlCountInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/", "/login", "/css/**", "/js/**", "/fonts/**","/images/**");
    }
}

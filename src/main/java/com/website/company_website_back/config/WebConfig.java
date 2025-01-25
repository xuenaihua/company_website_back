package com.website.company_website_back.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class WebConfig implements WebMvcConfigurer {

//    @Resource
//    private VisitorInterceptor visitorInterceptor;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(visitorInterceptor)
//                .addPathPatterns("/**")
//                .excludePathPatterns(
//                        "/login",
//                        "/register",
//                        "/css/**",
//                        "/js/**",
//                        "/images/**"
//                ); // 排除登录页面、静态资源等
//    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 将本地文件夹映射为URL路径
        registry.addResourceHandler("/uploads/**")
                .addResourceLocations("file:uploads/"); // 本地文件夹路径
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // 对所有请求路径开启CORS
                .allowedOrigins("*")  // 允许的源地址
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // 允许的请求方法
                .allowedHeaders("*");  // 允许的请求头
    }
}


//package com.website.company_website_back.config;
//
//import io.github.bucket4j.Bandwidth;
//import io.github.bucket4j.Bucket;
//import io.github.bucket4j.Bucket4j;
//import io.github.bucket4j.Refill;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.time.Duration;
//
////@Component
////@WebFilter(urlPatterns = "/api/*")  // 限流过滤器作用于 /api/* 路径
//public class RateLimiterFilter implements Filter {
//
//    private static final int CAPACITY = 10;  // 每秒最多请求次数
//    private static final int REFILL_INTERVAL = 1;  // 每秒填充桶的时间间隔
//    private static final int REFILL_AMOUNT = 10;  // 每秒填充的数量
//
//    private final Bucket bucket;
//
//    public RateLimiterFilter() {
//        // 设置限流桶
//        Refill refill = Refill.intervally(REFILL_AMOUNT, Duration.ofSeconds(REFILL_INTERVAL));
//        Bandwidth limit = Bandwidth.classic(CAPACITY, refill);
//        this.bucket = Bucket4j.builder().addLimit(limit).build();
//    }
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        // 初始化时可以做一些资源准备等
//    }
//
//    @Override
//    public void doFilter(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, FilterChain chain)
//            throws IOException, ServletException {
//
//        HttpServletRequest httpRequest = (HttpServletRequest) request;
//        HttpServletResponse httpResponse = (HttpServletResponse) response;
//
//        // 判断当前请求是否超出了限流限制
//        if (bucket.tryConsume(1)) {  // 每次请求消耗 1 个令牌
//            // 如果请求没超限，继续处理请求
//            chain.doFilter(request, response);
//        } else {
//            // 如果超出请求频率限制，返回 40 Too Many Requests
//            httpResponse.setStatus(HttpServletResponse.SC_NOT_FOUND);
//            httpResponse.getWriter().write("Too many requests. Please try again later.");
//        }
//    }
//
//    @Override
//    public void destroy() {
//        // 清理资源
//    }
//}
//

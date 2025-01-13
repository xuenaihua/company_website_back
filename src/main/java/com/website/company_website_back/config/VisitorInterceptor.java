package com.website.company_website_back.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class VisitorInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();

        // 只有访问首页或者首页下的页面才能继续
        if (uri.startsWith("/home") || uri.equals("/")) {
            return true;
        }

        // 对于其他页面需要登录
        if (!isUserLoggedIn(request)) {
            response.sendRedirect("/home");
            return false;
        }

        return true;
    }

    private boolean isUserLoggedIn(HttpServletRequest request) {
        return request.getSession().getAttribute("user") != null;
    }
}


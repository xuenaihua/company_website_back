package com.website.company_website_back.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/home/**").permitAll()  // 允许游客访问首页及其下的页面
                .antMatchers("/admin/**").authenticated()  // 管理员页面需要登录
                .anyRequest().denyAll()  // 其他页面访问禁止
                .and()
                .formLogin()
                .loginPage("/login")  // 设置登录页面路径
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 配置用户登录验证，这里可以接入数据库或内存验证
        auth.inMemoryAuthentication()
                .withUser("admin").password("{noop}admin123").roles("ADMIN")
                .and()
                .withUser("user").password("{noop}user123").roles("USER");
    }
}


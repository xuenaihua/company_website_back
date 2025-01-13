package com.website.company_website_back;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.website.company_website_back.mapper")
public class CompanyWebsiteBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompanyWebsiteBackApplication.class, args);
    }

}

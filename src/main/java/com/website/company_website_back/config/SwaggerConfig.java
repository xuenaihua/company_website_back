package com.website.company_website_back.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Slf4j
@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {

    @Value("${springfox.documentation.enabled:false}")
    private boolean enabled;

    @Bean
    public Docket api() {
        log.info("Swagger2 enabled: {}", enabled);
        log.info("Swagger2 url: {}", "http://localhost:12264/doc.html");
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(enabled)
                .apiInfo(apiInfo())
                .select()
                //替换为你的控制器包路径
                .apis(RequestHandlerSelectors.basePackage("com.website.company_website_back.controller"))
                .paths(PathSelectors.any())
                .build();
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .license("license")
                .title("xx系统API文档")
                .description("测试系统")
                .version("1.0")
                .build();
    }
}

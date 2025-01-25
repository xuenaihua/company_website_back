# 基于官方的 Java 8 镜像
FROM openjdk:8-jdk-alpine

# 添加 JAR 文件到镜像
ADD target/company_website_back-1.0.0.jar app.jar

# 暴露 Spring Boot 应用的默认端口
EXPOSE 12264

# 运行 Spring Boot 应用
ENTRYPOINT ["java", "-jar", "app.jar"]

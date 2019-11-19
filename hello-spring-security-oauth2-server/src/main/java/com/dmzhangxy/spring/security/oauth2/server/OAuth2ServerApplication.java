package com.dmzhangxy.spring.security.oauth2.server;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
//加入包扫描路径
@MapperScan(basePackages = "com.dmzhangxy.spring.security.oauth2.server.mapper")
public class OAuth2ServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(OAuth2ServerApplication.class,args);
    }
}

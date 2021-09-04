package com.wu.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@MapperScan("com.wu.admin.mapper")
@ServletComponentScan(basePackages = "com.wu.admin")
@SpringBootApplication
public class Boot2AdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(Boot2AdminApplication.class, args);
    }

}

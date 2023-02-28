package com.dev.enter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.dev.enter.mapper")
public class EnterLevelSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(EnterLevelSystemApplication.class, args);
    }

}

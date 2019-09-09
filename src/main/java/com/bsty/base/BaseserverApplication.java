package com.bsty.base;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bsty.base.dao")
public class BaseserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaseserverApplication.class, args);
    }

}

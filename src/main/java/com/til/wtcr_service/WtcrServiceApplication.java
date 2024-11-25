package com.til.wtcr_service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.graphql.data.GraphQlRepository;

@MapperScan("com.til.wtcr_service.mapper")
@SpringBootApplication
public class WtcrServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WtcrServiceApplication.class, args);
    }

}

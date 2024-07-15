package com.java.mod;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class ModApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModApplication.class, args);
    }

}

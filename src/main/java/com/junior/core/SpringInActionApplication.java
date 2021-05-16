package com.junior.core;

import com.junior.controller.HomeController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringInActionApplication {

    public static void main(String[] args) {
        SpringApplication.run(new Class[]{SpringInActionApplication.class, HomeController.class}, args);
    }

}

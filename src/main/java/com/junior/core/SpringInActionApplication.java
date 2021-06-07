package com.junior.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@SpringBootApplication(scanBasePackages = "com.junior")
public class SpringInActionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringInActionApplication.class, args);
    }

    @Bean
    public DataSource mysqlDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/spring");
        dataSource.setUsername("abdalrazag");
        dataSource.setPassword("xr#33xngAbod");

        return dataSource;
    }

}

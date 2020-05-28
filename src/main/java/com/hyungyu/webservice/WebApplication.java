package com.hyungyu.webservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.thymeleaf.dialect.springdata.SpringDataDialect;

@SpringBootApplication
@EntityScan(basePackageClasses = {WebApplication.class, Jsr310JpaConverters.class})
@EnableJpaAuditing
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

    @Bean
    public SpringDataDialect springDataDialect() { return new SpringDataDialect(); }

}

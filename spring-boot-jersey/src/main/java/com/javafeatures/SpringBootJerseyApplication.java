package com.javafeatures;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringBootJerseyApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        new SpringBootJerseyApplication().configure(new SpringApplicationBuilder(SpringBootJerseyApplication.class)).run(args);
    }
}

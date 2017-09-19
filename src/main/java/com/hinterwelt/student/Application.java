package com.hinterwelt.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//@Configuration
//@EnableAutoConfiguration
@EnableEurekaClient

public class Application {

    public static void main(String[] args) {
 
        SpringApplication.run(Application.class, args);
    }

}

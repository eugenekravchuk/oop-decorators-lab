package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        
        String credentialsPath = "../credentials.json";
        System.setProperty("GOOGLE_APPLICATION_CREDENTIALS", credentialsPath);

        SpringApplication.run(DemoApplication.class, args);
    }
}
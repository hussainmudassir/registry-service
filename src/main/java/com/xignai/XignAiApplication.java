package com.xignai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class XignAiApplication {
    public static void main(String[] args) {
        SpringApplication.run(XignAiApplication.class, args);
        System.out.println("XignAi service is up and running!!");
    }
}
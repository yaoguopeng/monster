package com.island.monster;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class MonsterApplication {

    @Value("${spring.envo}")
    private String envo;

    public static void main(String[] args) {
        SpringApplication.run(MonsterApplication.class, args);
    }

    @RequestMapping("/")
    public String hello(){
        return "Welcome to TIME ISLAND "+envo;
    }
}

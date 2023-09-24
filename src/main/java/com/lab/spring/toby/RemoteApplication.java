package com.lab.spring.toby;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RemoteApplication {
    @Slf4j
    @RestController
    @RequiredArgsConstructor
    public static class RemoteController{
        private final RestTemplate restTemplate;
        @GetMapping("/{id}")
        public String getUser(@PathVariable int id){
            log.info("유저 : {}", id);
            String user = restTemplate.getForObject("http://localhost:8081/getUser/" + id, String.class);
            log.info("유저 정보 : {}", user);
            return user;
        }

    }
    public static void main(String[] args) {
        System.setProperty("server.port", "8080");
        System.setProperty("server.tomcat.threads.max", "10");
        SpringApplication.run(RemoteApplication.class, args);
    }

}

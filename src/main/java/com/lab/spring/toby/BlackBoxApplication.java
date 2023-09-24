package com.lab.spring.toby;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class BlackBoxApplication {

    @Slf4j
    @RestController
    public static class BlackBoxController{
        @GetMapping("/getUser/{id}")
        public String getUser(@PathVariable int id) throws InterruptedException {
//            log.info("1초 쉼니다.");
            Thread.sleep(1000);
//            log.info("1초 끝.");
            log.info("{} 번 유저", id);
            return id + "번 유저 입니다.";
        }
    }
    public static void main(String[] args) {
        System.setProperty("server.port", "8081");
        System.setProperty("server.tomcat.threads.max", "100");
        SpringApplication.run(BlackBoxApplication.class, args);
    }

}

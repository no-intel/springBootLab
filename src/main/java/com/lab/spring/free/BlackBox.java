package com.lab.spring.free;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/blackBox")
public class BlackBox {
    @GetMapping
    public void sleep(){
        log.info("20초간 멈춥니다.");
        try {
            Thread.sleep(1000 * 20);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("1분 끝");
    }

    @GetMapping("/test")
    public void test(){
        log.info("테스트 입니다.");
    }

    @GetMapping("/1")
    public ResponseEntity<Integer> return1(){
        log.info("20초간 멈춥니다.");
        try {
            Thread.sleep(1000 * 20);
            log.info("20초 끝");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<>(1, HttpStatus.OK);
    }
    @GetMapping("/2")
    public ResponseEntity<Integer> return2(){
        log.info("20초간 멈춥니다.");
        try {
            Thread.sleep(1000 * 20);
            log.info("20초 끝");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<>(12, HttpStatus.OK);
    }
}

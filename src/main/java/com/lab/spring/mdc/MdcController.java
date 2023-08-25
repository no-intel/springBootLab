package com.lab.spring.mdc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mdc")
public class MdcController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @GetMapping("/")
    public void test(){
        log.info("테스트 시작");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("테스트 끝");
    }
}

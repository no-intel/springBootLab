package com.lab.spring.timeout;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/timeout")
public class TimeoutController {
    private final RestTemplate restTemplate;

    @GetMapping()
    public void timeout() {
        log.info("테스트 start");
        restTemplate.getForObject("http://localhost:8081/timeout/conn", Object.class);
        log.info("테스트 end");
    }

    @GetMapping("/conn")
    public void conn() {
        log.info("conn start");
        try {
            Thread.sleep(1000 * 60 * 3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("conn end");
    }
}

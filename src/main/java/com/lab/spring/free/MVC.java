package com.lab.spring.free;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/mvc")
@RequiredArgsConstructor
public class MVC {
    private final RestTemplate restTemplate;
    @GetMapping()
    public void timeout() {
        restTemplate.getForObject("http://localhost:8081/blackBox", Object.class);
        System.out.println("블록킹");
//        restTemplate.getForObject("http://localhost:8081/blackBox/test", Object.class);
    }
}

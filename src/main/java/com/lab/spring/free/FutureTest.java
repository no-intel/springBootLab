package com.lab.spring.free;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
@RestController
@RequestMapping("/future")
@RequiredArgsConstructor
public class FutureTest {

    private final RestTemplate restTemplate;

    @GetMapping
    public void future() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() ->{
            log.info("1 시작 : " + Thread.currentThread().getName());
            Integer forObject = restTemplate.getForObject("http://localhost:8081/blackBox/1", Integer.class);
            log.info("1 끝 : " + Thread.currentThread().getName());
            return forObject;
        }).thenApply((value)->{
            log.info(Thread.currentThread().getName() + ": " + value);
            return value + 1;
        });

        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() ->{
            log.info("2 시작 : " + Thread.currentThread().getName());
            Integer forObject = restTemplate.getForObject("http://localhost:8082/blackBox/2", Integer.class);
            log.info("2 끝 : " + Thread.currentThread().getName());
            return forObject;
        }).thenApply((value)->{
            log.info(Thread.currentThread().getName() + ": " + value);
            return value + 1;
        });
        long beforeTime = System.currentTimeMillis();
        long num = 0L;
        while ((System.currentTimeMillis() - beforeTime)/1000 < 3){
            num++;
        }

        Thread.sleep(10000);
        beforeTime = System.currentTimeMillis();
        while ((System.currentTimeMillis() - beforeTime)/1000 < 3){
            num--;
        }

        Thread.sleep(10000);
        beforeTime = System.currentTimeMillis();
        while ((System.currentTimeMillis() - beforeTime)/1000 < 3){
            num++;
        }

        Integer integer1 = future1.get();
        Integer integer2 = future2.get();
        log.info("Thread : " + Thread.currentThread().getName());
        log.info("num : " + num);
        System.out.println(num + integer1 + integer2);
    }

    @GetMapping("/sync")
    public void sync() {
        Integer forObject = restTemplate.getForObject("http://localhost:8081/blackBox/1", Integer.class);
        Integer forObject1 = restTemplate.getForObject("http://localhost:8082/blackBox/2", Integer.class);
        System.out.println(forObject + forObject1);
    }
}

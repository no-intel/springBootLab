package com.lab.spring.threadExcutor;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/excutor")
public class ExcutorController {
    private final ThreadPoolTaskExecutor executor;

    @GetMapping()
//    @Async
    public void excutorThread() {
        log.info("executing threads...");
        Runnable r = () -> {
            try {
                log.info(Thread.currentThread().getName() + ", Now sleeping 10 sec...");
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        for (int i = 0; i < 10; i++) {
            executor.execute(r);
            log.info("poolSize : " + executor.getCorePoolSize()
                    + ", activeCount : " + executor.getActiveCount()
                    + ", queueSize : " + executor.getThreadPoolExecutor().getQueue().size()
            );
        }
    }

//    @Async
    @GetMapping("/test")
    public void test(){
        try {
            log.info("test " + Thread.currentThread().getName() + ", Now sleeping 10 sec...");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}

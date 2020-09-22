package com.wallmart.challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootApplication
@EnableAsync
public class ChallengeApplication {

    @Bean("miEjecutadorHilos")
    public TaskExecutor getAsyncEjecutador() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(100);
        executor.setMaxPoolSize(1000);
        executor.setQueueCapacity(5000);
        executor.setThreadNamePrefix("Async-");
        executor.initialize();
        return executor;
    }

    public static void main(String[] args) {
        SpringApplication.run(ChallengeApplication.class, args);

    }

}

package com.stealandfire;

import com.stealandfire.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@Slf4j
@EnableAsync
@SpringBootApplication
public class MyApplication implements ApplicationRunner {
    @Autowired
    private IUserService userService;

    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) {
        log.info("Spring Application already run.");
        userService.getCachableString("key1");
    }
}

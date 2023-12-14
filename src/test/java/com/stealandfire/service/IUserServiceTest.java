package com.stealandfire.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class IUserServiceTest {
    @Autowired
    private IUserService userService;

    @Test
    public void testFun2() {
        userService.fun2();
    }

    @Test
    public void testTransaction() {
        userService.transaction();
    }
}
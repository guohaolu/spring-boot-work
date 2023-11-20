package com.stealandfire;

import com.stealandfire.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class SpringBootApplicationTests {
    @Autowired
    private IUserService userService;

    @Test
    public void testFun1() {
        String str = userService.fun1();
        log.info(str);
    }

    @Test
    public void testFun2() {
        userService.fun2();
    }

}

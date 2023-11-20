package com.stealandfire.demo.redis;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.Cacheable;

@Slf4j
@SpringBootTest
public class RedissonTest {
    @Autowired
    private RedissonClient redisson;

    @Test
    public void testRedisson() {
        RBucket<String> bucket = redisson.getBucket("test");
        bucket.set("test");
        log.info("testRedisson: {}", bucket.get());
    }
}

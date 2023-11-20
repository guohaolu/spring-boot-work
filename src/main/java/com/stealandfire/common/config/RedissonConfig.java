package com.stealandfire.common.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Redisson配置
 */
@Configuration
public class RedissonConfig {
    private static final String REDISSON_PREFIX = "redis://";

    @Value("${spring.redis.host}")
    private String redisHost;

    @Value("${spring.redis.port}")
    private String redisPort;

    @Value("${spring.redis.password}")
    private String password;

    /**
     * redisson客户端
     *
     * @return RedissonClient
     */
    @Bean(destroyMethod = "shutdown")
    public RedissonClient redisson() {
        // 1、创建配置
        Config config = new Config();
        config.useSingleServer()
                .setAddress(REDISSON_PREFIX + redisHost + ":" + redisPort)
               .setPassword(password);
        // 2、根据 Config 创建出 RedissonClient 实例
        return Redisson.create(config);
    }
}

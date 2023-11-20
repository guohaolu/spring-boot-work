package com.stealandfire.common.config;

import com.stealandfire.common.mybatis.plugin.ExamplePlugin;
import com.stealandfire.common.mybatis.plugin.PagedPlugin;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * {@code Mybatis}配置
 */
@Configuration
public class MybatisConfig {
    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return configuration ->  {
            configuration.addInterceptor(new ExamplePlugin());
            configuration.addInterceptor(new PagedPlugin());
        };
    }
}

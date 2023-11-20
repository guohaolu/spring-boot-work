package com.stealandfire.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * {@code Spring}事务配置
 */
@Configuration
@EnableTransactionManagement
public class TransactionConfig implements TransactionManagementConfigurer {
    @Resource
    private DataSource dataSource;

    /**
     * 事务管理器
     *
     * @return 事务管理器
     */
    @Bean
    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }
}
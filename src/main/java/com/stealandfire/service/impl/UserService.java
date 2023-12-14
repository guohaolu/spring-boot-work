package com.stealandfire.service.impl;

import com.stealandfire.common.aop.CostEnable;
import com.stealandfire.manager.UserManager;
import com.stealandfire.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

@Slf4j
@Service
public class UserService implements IUserService {
    public static final String CACHE_USER = "User";

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserManager userManager;

    @Override
    public String fun1() {
        ((IUserService) AopContext.currentProxy()).fun2();
        return "fun1";
    }

    @Override
    @CostEnable
    public void fun2() {
        System.out.println("fun2 execute.");
    }

    @Override
    @Cacheable(value = CACHE_USER, key = "#key")
    public String getCachableString(String key) {
        return key + "test";
    }

    @Override
    @Transactional
    public void transaction() {
        userManager.insertUser();
        jdbcTemplate.update("insert into tpl_user_t(name) values(?)", Thread.currentThread().getName());
        log.info(this.getClass().getName() + ": insertUser");
    }
}

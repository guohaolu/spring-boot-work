package com.stealandfire.manager;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

@Slf4j
@Component
public class UserManager {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Async
    @Transactional
    public void insertUser() {
        jdbcTemplate.update("insert into tpl_user_t(name) values(?)", Thread.currentThread().getName());
        int x = 1 / 0;
        log.info(this.getClass().getName() + ": insertUser");
    }
}

package com.stealandfire.service.impl;

import com.stealandfire.common.aop.CostEnable;
import com.stealandfire.service.IUserService;
import org.springframework.aop.framework.AopContext;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    public static final String CACHE_USER = "User";

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
}

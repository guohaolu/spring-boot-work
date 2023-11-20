package com.stealandfire.common.mybatis.plugin;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Invocation;

public class PagedPlugin implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        return invocation.proceed();
    }
}

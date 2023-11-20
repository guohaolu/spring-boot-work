package com.stealandfire.common.mybatis.plugin;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.Arrays;

@Slf4j
@Intercepts({@Signature(
        type= Executor.class,
        method = "query",
        args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})})
public class ExamplePlugin implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        // implement pre-processing
        log.info("pre-processing: ");
        log.info("\n" + "target: " + invocation.getTarget() + "\n" +
                "method: " + invocation.getMethod() + "\n" +
                "args: " + Arrays.toString(invocation.getArgs()));
        MappedStatement ms = (MappedStatement) invocation.getArgs()[0];
        BoundSql boundSql = ms.getBoundSql(invocation.getArgs()[1]);
        RowBounds rowBounds = (RowBounds) invocation.getArgs()[2];
        log.info("boundSql: " + boundSql);
        log.info("sqlSource: " + ms.getSqlSource());
        log.info("RowBound: " + rowBounds.getLimit() + " " + rowBounds.getOffset());
        Object returnObject = invocation.proceed();

        // implement post-processing
        log.info("post-processing: ");
        return returnObject;
    }

}
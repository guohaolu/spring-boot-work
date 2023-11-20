package com.stealandfire.common.aop;

import java.lang.annotation.*;

/**
 * @see CostInterceptor
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface CostEnable {
}

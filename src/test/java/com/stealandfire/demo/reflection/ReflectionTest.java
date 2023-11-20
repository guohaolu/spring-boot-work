package com.stealandfire.demo.reflection;

import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Slf4j
public class ReflectionTest {
    private static int count = 1;

    public static void testException() {
        new Exception("testException#" + (count++)).printStackTrace();
    }

    @Test
    public void testMethodInvoke() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchFieldException {
        ReflectionTest self = new ReflectionTest();
        var m = self.getMethodObj();
        Class<?> mClazz = m.getClass();
        System.out.println(mClazz);
        // This is necessary due to some aspects of lazy evaluation
        m.invoke(null);

        var f = mClazz.getDeclaredField("methodAccessor");
        f.setAccessible(true);
        Object ma = f.get(m);
        System.out.println(ma.getClass());
    }

    public static void printStr() {
        System.out.println("Hello world");
    }

    public Method getMethodObj() throws NoSuchMethodException {
        var selfClazz = getClass();
        var toStr = selfClazz.getMethod("printStr");
        return toStr;
    }
}

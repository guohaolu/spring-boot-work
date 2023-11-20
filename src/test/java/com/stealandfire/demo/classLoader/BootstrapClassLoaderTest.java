package com.stealandfire.demo.classLoader;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * 关于{@code class loader}的学习
 *
 * @see ClassLoader
 * @see java.net.URLClassLoader
 */
@Slf4j
public class BootstrapClassLoaderTest {
    @SneakyThrows
    public static void main(String[] args) {
        ClassLoader loader = new NetworkClassLoader("127.0.01", 8003);
        Object main = loader.loadClass("com.stealandfire.demo.classLoader.TestClassXXX").newInstance();
        System.out.println(main);
        System.out.println(main.getClass().getClassLoader());
    }
}

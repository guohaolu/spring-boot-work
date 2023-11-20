package com.stealandfire.demo.classLoader;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.util.Assert;
import org.springframework.util.FileCopyUtils;

import java.io.File;

/**
 * 网络类加载器
 */
@RequiredArgsConstructor
public class NetworkClassLoader extends ClassLoader {
    private final String host;
    private final int port;

    public Class<?> findClass(String name) {
        byte[] bytes = loadClassData(name);
        Assert.notNull(bytes, "NetworkClassLoader # findClass 的字节数组不允许为null");
        return defineClass(name, bytes, 0, bytes.length);
    }

    @SneakyThrows
    private byte[] loadClassData(String name) {
        // load the class data from the connection
        File file = new File("D:\\test\\com\\stealandfire\\demo\\classLoader\\TestClassXXX.class");
        System.out.println("自定义类加载器：NetworkClassLoader 执行。。。");
        return FileCopyUtils.copyToByteArray(file);
    }
}

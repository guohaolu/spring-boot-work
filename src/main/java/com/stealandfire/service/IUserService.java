package com.stealandfire.service;

public interface IUserService {
    String fun1();

    void fun2();

    /**
     * 获取缓存
     *
     * @param key 键
     * @return 对应的值
     */
    String getCachableString(String key);
}

package com.stealandfire.demo;

import java.beans.Introspector;

public class BeanNameTest {
    public static void main(String[] args) {
        String clazzName = "I";
        String resolvedName = Introspector.decapitalize(clazzName);
        System.out.println(resolvedName);
    }
}

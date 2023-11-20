package com.stealandfire.demo.thread;

import java.util.HashMap;
import java.util.Map;

public class MethodInvokeTest {
    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        HashMap<String, String> hm = new HashMap<>();
        hm.put("now", "bar");
        Map<String, String> m = hm;
        m.put("foo", "baz");
        System.out.println("11");
    }
}

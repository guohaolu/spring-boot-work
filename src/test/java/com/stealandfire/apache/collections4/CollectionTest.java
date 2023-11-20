package com.stealandfire.apache.collections4;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionTest {
    private static final List<String> l1 = Stream.of("a", "b", "c", "d").collect(Collectors.toList());

    @Test
    public void testConverter() {
        Collection<String> l2 = CollectionUtils.collect(l1, x -> x + "已经转换");
        System.out.println(l2);
    }

    @Test
    public void testConverter2() {
        Collection<String> l2 = CollectionUtils.collect(l1, x -> x + "已经转换");
        System.out.println(l2);
    }
}

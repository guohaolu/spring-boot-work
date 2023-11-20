package com.stealandfire.google.guava;

import com.google.common.base.Strings;
import org.junit.jupiter.api.Test;

public class StringTest {
    private static final String STR = "k";

    @Test
    public void testConverter() {
        String result = Strings.padStart(STR, 10, '0');
        System.out.println(result);
    }
}

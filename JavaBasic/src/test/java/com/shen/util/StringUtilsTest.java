package com.shen.util;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StringUtilsTest {
    @Test
    public void testTrimAll(){
        String s = "hello";
        String str = " he l lo  ";
        Assert.assertEquals(StringUtils.trimAll(str), s);
    }

    @Test
    public void testReverse(){
        String str = "shen";
        Assert.assertEquals(StringUtils.reverse(str), "naijnus");
    }
}

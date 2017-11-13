package com.mlj.dangdang.test;

import com.mlj.dangdang.util.MD5Util;
import org.junit.Test;

public class TestMd5 {

    @Test
    public void test() {
        String pass = "menglinjie";
        boolean b = MD5Util.verify(pass, MD5Util.generate(pass));
        System.out.println(b);
    }
}

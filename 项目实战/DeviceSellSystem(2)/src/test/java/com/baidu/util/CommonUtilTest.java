package com.baidu.util;

import static org.junit.Assert.assertNotNull;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

public class CommonUtilTest {

    @Test
    public void testMd5() throws UnsupportedEncodingException {
        String md5 = CommonUtil.md5("admin");
        assertNotNull(md5);
        System.out.println(md5);
    }

}

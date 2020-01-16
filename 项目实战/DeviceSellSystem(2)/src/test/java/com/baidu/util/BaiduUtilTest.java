package com.baidu.util;

import org.junit.Assert;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.baidu.util.BaiduUtil.IdCardFront;

public class BaiduUtilTest {

    @Test
    public void testGetIdCardFrontInfo() {
        String url = "C:\\Users\\Administrator\\Desktop\\timg.jfif";
        IdCardFront idCardFrontInfo = BaiduUtil.getIdCardFrontInfo(url);
        Assert.assertNotNull(idCardFrontInfo);
        System.out.println(JSON.toJSONString(idCardFrontInfo));
    }

}

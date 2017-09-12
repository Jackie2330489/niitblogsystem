package com.niitblogsystem.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Justin on 2017/9/12.
 */
public class EmailHelperTest {
    @Test
    public void sendEmailVerCode() throws Exception {
        int code=EmailHelper.sendEmailVerCode("jiumam123@qq.com");
        System.out.println(code);
    }

}
/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.alipay.mvcdemo;

import com.alipay.sofa.runtime.test.junit.JunitEclipseSofaTest;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author yinywf
 * @version $Id: SampleJunit3TestCase, v 0.1 2018-06-06 14:39 yinywf Exp $
 */
public class SampleJunit3TestCase extends JunitEclipseSofaTest {


    @Test
    public void test() {
        Assert.assertTrue(true);
    }


    @Override
    public String[] getRpcServiceConfigurationLocations() {
        return new String[]{"test_rpc.xml"};
    }
}

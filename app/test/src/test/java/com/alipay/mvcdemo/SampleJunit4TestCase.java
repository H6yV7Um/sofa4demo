/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.alipay.mvcdemo;

import com.alipay.sofa.runtime.test.autowire.annotation.XAutoWire;
import com.alipay.sofa.runtime.test.autowire.annotation.XConfigure;
import com.alipay.sofa.runtime.test.autowire.annotation.XMode;
import com.alipay.sofa.runtime.test.junit4.SofaJUnit4ClassRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author yinywf
 * @version $Id: SampleJunit3TestCase, v 0.1 2018-06-06 14:39 yinywf Exp $
 */
@XMode(XMode.RPC)
@XConfigure(rpcConfigLocation = "test_rpc.xml")
@RunWith(SofaJUnit4ClassRunner.class)
public class SampleJunit4TestCase {

    @XAutoWire(XAutoWire.BY_SERVICE)
    private SampleTrService sampleTrService;

    @Test
    public void test() {
        System.out.println(sampleTrService.service());
        Assert.assertEquals("hello from remote", sampleTrService.service());
    }
}

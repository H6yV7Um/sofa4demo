/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.alipay.mvcdemo.test;

import com.alipay.common.event.UniformEventMessageListener;
import com.alipay.mvcdemo.msgBroker.UniformEventPublisherService;
import com.alipay.sofa.runtime.test.autowire.annotation.XAutoWire;
import com.alipay.sofa.runtime.test.autowire.annotation.XMode;
import com.alipay.sofa.runtime.test.junit4.SofaJUnit4ClassRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author yinywf
 * @version $Id: MsgBrokerTest, v 0.1 2018-06-08 12:13 yinywf Exp $
 */

@XMode(XMode.JVM)
@RunWith(SofaJUnit4ClassRunner.class)
public class MsgBrokerTest {

    @XAutoWire(value = XAutoWire.BY_NAME, module = "com.alipay.mvcdemo.core.service")
    private UniformEventPublisherService uniformEventPublisherService;

    @XAutoWire(value = XAutoWire.BY_SERVICE, module = "com.alipay.mvcdemo.core.service")
    private UniformEventMessageListener uniformEventMessageListener;

    @Test
    public void test() {
        uniformEventPublisherService.publicUniformEvent("TP_DEFAULT_UNIFORM_EVENT", "EC_TUTORIAL_JIUSUI", "hello msgBroker");

        /*  Assert.assertEquals("hello from remote", sampleTrService.service());*/
    }
}

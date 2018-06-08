/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.alipay.mvcdemo;

import com.alipay.mvcdemo.msgBroker.UniformEventPublisherService;
import com.alipay.sofa.runtime.api.annotation.SofaService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author yinywf
 * @version $Id: SampleServiceImpl, v 0.1 2018-06-05 14:53 yinywf Exp $
 */
@SofaService(uniqueId = "sampleRemote")
public class SampleServiceImpl2 implements SampleService {


    private SampleTrService sampleTrService;

    @Autowired
    private UniformEventPublisherService uniformEventPublisherService;

    @Override
    public String hello() {
        uniformEventPublisherService.publicUniformEvent("TP_DEFAULT_UNIFORM_EVENT", "EC_TUTORIAL_JIUSUI", "hello msgBroker");
        return sampleTrService.service();
    }

    /**
     * Setter method for property <tt>counterType</tt>.
     *
     * @param sampleTrService value to be assigned to property sampleTrService
     */
    public void setSampleTrService(SampleTrService sampleTrService) {
        this.sampleTrService = sampleTrService;
    }
}

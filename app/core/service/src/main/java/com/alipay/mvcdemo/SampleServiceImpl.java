/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.alipay.mvcdemo;

import com.alipay.sofa.runtime.api.annotation.SofaService;

/**
 * @author yinywf
 * @version $Id: SampleServiceImpl, v 0.1 2018-06-05 14:53 yinywf Exp $
 */
@SofaService(uniqueId = "sample")
public class SampleServiceImpl implements SampleService {
    @Override
    public String hello() {
        return "SOFA4";
    }
}

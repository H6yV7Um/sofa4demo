/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.alipay.mvcdemo;

/**
 * @author yinywf
 * @version $Id: SampleTrServiceImpl, v 0.1 2018-06-05 17:37 yinywf Exp $
 */

public class SampleTrServiceImpl implements SampleTrService {
    @Override
    public String service() {
        return "hello from remote!";
    }
}

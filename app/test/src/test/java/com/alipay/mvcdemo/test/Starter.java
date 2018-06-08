package com.alipay.mvcdemo.test;

import com.alipay.sofa.runtime.test.SofaStarter;
import com.alipay.sofa.runtime.test.SofaTestConstants;

/**
 * SOFA 的启动类
 *
 * @author khotyn 8/22/14 3:38 PM
 */
public class Starter {
    public static void main(String[] args) {
                SofaStarter.getInstance().start(SofaTestConstants.WEB_APP);
    }
}

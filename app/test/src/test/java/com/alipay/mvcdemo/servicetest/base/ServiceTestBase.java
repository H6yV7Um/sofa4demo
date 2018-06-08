/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.mvcdemo.servicetest.base;

import com.alipay.ats.config.PropertyConfig;
import com.alipay.ats.sofa3.Sofa3DataDriver;

/**
 * 
 * @author huifeng.xie
 * @version $Id: DemoTestBase.java, v 0.1 2014/7/3 下午4:29:14 huifeng.xie Exp $
 */
public class ServiceTestBase extends Sofa3DataDriver {	
	
	@Override
    public String[] getRpcServiceConfigurationLocations(){
		return new String[]{"remote/remote-beans.xml"};
	}
	
	/**
     * custom sofa-config.properties file load rule
     * @return
     * @see com.alipay.ats.base.SofaTestDriver#getConfigPattern()
     */
    @Override
    public String[] getConfigPattern() {
        return PropertyConfig.getTestConfigPattern();
    }
}

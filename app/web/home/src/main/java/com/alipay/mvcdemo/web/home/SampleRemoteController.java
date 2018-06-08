/**
 * Alipay.com Inc.
 * Copyright (c) 2005-2010 All Rights Reserved.
 */
package com.alipay.mvcdemo.web.home;

import com.alipay.mvcdemo.SampleService;
import com.alipay.sofa.runtime.api.annotation.AppConfig;
import com.alipay.sofa.runtime.api.annotation.SofaReference;
import com.alipay.sofa.runtime.api.component.AppConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * A sample controller.
 */
@Controller
public class SampleRemoteController {

    @SofaReference(uniqueId = "sampleRemote")
    private SampleService sampleServiceRemote;

    @SofaReference(uniqueId = "sample")
    private SampleService sampleService;

    private AppConfiguration appConfiguration;

    @AppConfig
    private AppConfiguration appConf;


    @AppConfig("hello")
    //hello的值为sofa
    private String hello;

    @RequestMapping(value = "/sampleRemote", method = RequestMethod.GET)
    public void doGet(ModelMap modelMap) {

        modelMap.put("hello", appConf.getPropertyValue("hello") + " " + hello + sampleServiceRemote.hello());

    }


 /*   @Override
    public void setAppConfiguration(AppConfiguration appConfiguration) {
        this.appConfiguration = appConfiguration;
    }*/
}

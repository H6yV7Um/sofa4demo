/**
 * Alipay.com Inc.
 * Copyright (c) 2005-2010 All Rights Reserved.
 */
package com.alipay.mvcdemo.web.home;

import com.alipay.dalgen.common.dal.dalgen_test.auto.daointerface.StudentDAO;
import com.alipay.dalgen.common.dal.dalgen_test.auto.dataobject.StudentDO;
import com.alipay.mvcdemo.SampleService;
import com.alipay.mvcdemo.StudentService;
import com.alipay.sofa.runtime.api.annotation.AppConfig;
import com.alipay.sofa.runtime.api.annotation.SofaReference;
import com.alipay.sofa.runtime.api.component.AppConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * A sample controller.
 */
@Controller
public class SampleController {

    @SofaReference(uniqueId = "sampleRemote")
    private SampleService sampleServiceRemote;

    @SofaReference(uniqueId = "sample")
    private SampleService sampleService;

    @SofaReference(uniqueId = "studentDao")
    private StudentDAO studentDAO;

    @SofaReference(uniqueId = "studentService")
    private StudentService studentService;

    private AppConfiguration appConfiguration;

    @AppConfig
    private AppConfiguration appConf;


    @AppConfig("hello")
    //hello的值为sofa
    private String hello;

    @RequestMapping(value = "/sample", method = RequestMethod.GET)
    public void doGet(@RequestParam(value = "id") String id, ModelMap modelMap) {


        // modelMap.put("hello", appConf.getPropertyValue("hello") + " " + id + hello + sampleServiceRemote.hello());
        modelMap.put("hello", studentDAO.select(Integer.parseInt(id)));
    }

    @RequestMapping(value = "/newSample", method = RequestMethod.GET)
    public void newSample(@RequestParam(value = "name") String name, @RequestParam(value = "school") String school, ModelMap modelMap) {

        // modelMap.put("hello", appConf.getPropertyValue("hello") + " " + id + hello + sampleServiceRemote.hello());
        StudentDO studentDO = new StudentDO();
        studentDO.setSchool(school);
        studentDO.setName(name);
        studentService.addStudent(studentDO);
        modelMap.put("hello", name + " " + school);

    }


 /*   @Override
    public void setAppConfiguration(AppConfiguration appConfiguration) {
        this.appConfiguration = appConfiguration;
    }*/
}

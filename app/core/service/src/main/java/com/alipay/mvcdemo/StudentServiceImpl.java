/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.alipay.mvcdemo;

import com.alipay.dalgen.common.dal.dalgen_test.auto.dataobject.StudentDO;
import com.alipay.mvcdemo.msgBroker.UniformEventPublisherService;
import com.alipay.sofa.runtime.api.annotation.SofaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author yinywf
 * @version $Id: StudentServiceImpl, v 0.1 2018-06-08 16:35 yinywf Exp $
 */

@SofaService(uniqueId = "studentService")
@Component
public class StudentServiceImpl implements StudentService {


    @Autowired
    private UniformEventPublisherService uniformEventPublisherService;

    @Override
    public int addStudent(StudentDO studentDO) {
        uniformEventPublisherService.publicUniformEvent("TP_DEFAULT_UNIFORM_EVENT", "EC_TUTORIAL_JIUSUI", studentDO);
        return 1;
    }
}

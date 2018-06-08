package com.alipay.mvcdemo;

import com.alipay.dalgen.common.dal.dalgen_test.auto.dataobject.StudentDO;

/**
 * @author yinywf
 * @version $Id: StudentService, v 0.1 2018-06-08 16:34 yinywf Exp $
 */
public interface StudentService {

    int addStudent(StudentDO studentDO);
}

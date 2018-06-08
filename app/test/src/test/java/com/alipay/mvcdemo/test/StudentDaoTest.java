/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.alipay.mvcdemo.test;

import com.alipay.dalgen.common.dal.dalgen_test.auto.daointerface.StudentDAO;
import com.alipay.dalgen.common.dal.dalgen_test.auto.dataobject.StudentDO;
import com.alipay.sofa.runtime.test.autowire.annotation.XAutoWire;
import com.alipay.sofa.runtime.test.autowire.annotation.XMode;
import com.alipay.sofa.runtime.test.junit.JunitEclipseSofaTest;

import java.sql.SQLException;

/**
 * @author yinywf
 * @version $Id: JdbcTest, v 0.1 2018-06-07 20:15 yinywf Exp $
 */
@XMode(XMode.JVM)
public class StudentDaoTest extends JunitEclipseSofaTest {

    @XAutoWire(value = XAutoWire.BY_NAME, module = "com.alipay.mvcdemo.common.dal")
    protected StudentDAO studentDAO;

    public void test() throws SQLException {

        StudentDO studentDO = new StudentDO();
        studentDO.setName("yinywf2");
        studentDO.setSchool("ant");
        studentDAO.insert(studentDO);

    }
}
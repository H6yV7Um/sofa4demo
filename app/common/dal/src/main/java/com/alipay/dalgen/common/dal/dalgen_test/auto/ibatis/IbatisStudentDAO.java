/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.alipay.dalgen.common.dal.dalgen_test.auto.ibatis;

import com.alibaba.common.lang.Paginator;
import com.alipay.dalgen.common.dal.dalgen_test.auto.daointerface.StudentDAO;
import com.alipay.dalgen.common.dal.dalgen_test.auto.dataobject.StudentDO;
import com.iwallet.biz.common.util.PageList;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * An ibatis based implementation of dao interface <tt>com.alipay.dalgen.common.dal.dalgen_test.auto.daointerface.StudentDAO</tt>.
 * <p>
 * This file is generated by <tt>dalgen-dalgen</tt>, a DAL (Data Access Layer)
 * code generation utility specially developed for <tt>dalgen</tt> project.
 * <p>
 * PLEASE DO NOT MODIFY THIS FILE MANUALLY, or else your modification may
 * be OVERWRITTEN by someone else. To modify the file, you should go to directory <tt>dalgen</tt>,
 * and find the corresponding configuration file (<tt>tables/student.xml</tt>).
 * Modify the configuration file according to your needs, then run <tt>dalgen-dalgen</tt> to generate this file.
 */

public class IbatisStudentDAO extends SqlMapClientDaoSupport implements StudentDAO {

    /**
     * @see com.alipay.dalgen.common.dal.dalgen_test.auto.daointerface.StudentDAO#insert(StudentDO)
     */
    public int insert(StudentDO student) {
        if (student == null) {
            throw new IllegalArgumentException("Can't insert a null data object into db.");
        }

        getSqlMapClientTemplate().insert("MS-STUDENT-INSERT", student);

        return student.getId();
    }

    /**
     * @see com.alipay.dalgen.common.dal.dalgen_test.auto.daointerface.StudentDAO#delete(int)
     */
    public int delete(int id) {
        Integer param = new Integer(id);

        return getSqlMapClientTemplate().delete("MS-STUDENT-DELETE", param);
    }

    /**
     * @see com.alipay.dalgen.common.dal.dalgen_test.auto.daointerface.StudentDAO#update(String, int)
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public int update(String name, int id) {
        Map param = new HashMap();

        param.put("name", name);
        param.put("id", new Integer(id));

        return getSqlMapClientTemplate().update("MS-STUDENT-UPDATE", param);
    }

    /**
     * @see com.alipay.dalgen.common.dal.dalgen_test.auto.daointerface.StudentDAO#select(int)
     */
    public StudentDO select(int id) {
        Integer param = new Integer(id);

        return (StudentDO) getSqlMapClientTemplate().queryForObject("MS-STUDENT-SELECT", param);

    }


    /**
     * @see com.alipay.dalgen.common.dal.dalgen_test.auto.daointerface.StudentDAO#selectList(String)
     */
    @SuppressWarnings("unchecked")
    public List<StudentDO> selectList(String school) {

        return getSqlMapClientTemplate().queryForList("MS-STUDENT-SELECT-LIST", school);

    }


    /**
     * @see com.alipay.dalgen.common.dal.dalgen_test.auto.daointerface.StudentDAO#selectWithPaging(String, int, int)
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public PageList selectWithPaging(String school, int pageSize, int pageNum) {
        Map param = new HashMap();

        param.put("school", school);
        param.put("pageSize", new Integer(pageSize));
        param.put("pageNum", new Integer(pageNum));

        Paginator paginator = new Paginator();
        paginator.setItemsPerPage(pageSize);
        paginator.setPage(pageNum);

        paginator.setItems(((Integer) getSqlMapClientTemplate().queryForObject("MS-STUDENT-SELECT-WITH-PAGING-COUNT-FOR-PAGING", param)).intValue());

        PageList pageList = new PageList();
        pageList.setPaginator(paginator);

        if (paginator.getBeginIndex() <= paginator.getItems()) {
            param.put("startRow", new Integer(paginator.getBeginIndex() - 1));
            pageList.addAll(getSqlMapClientTemplate().queryForList("MS-STUDENT-SELECT-WITH-PAGING", param));
        }

        return pageList;
    }

}
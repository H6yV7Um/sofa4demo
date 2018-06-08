/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.alipay.dalgen.common.dal.dalgen_test.auto;

import com.alipay.dalgen.common.dal.dalgen_test.auto.daointerface.StudentDAO;
import com.alipay.dalgen.common.dal.dalgen_test.auto.dataobject.StudentDO;
import com.alipay.sofa.runtime.api.annotation.SofaService;
import com.iwallet.biz.common.util.PageList;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author yinywf
 * @version $Id: StudentDaoImpl, v 0.1 2018-06-08 15:55 yinywf Exp $
 */
@Component
@SofaService(uniqueId = "studentDao")
public class StudentDaoImpl implements StudentDAO {

    private DataSource dataSource;

    @Override
    public int insert(StudentDO student) {
        try {
            Connection connection = dataSource.getConnection();
            // Insert data
            String insertSql = "INSERT INTO student ( name,school) values (?, ?)";
            PreparedStatement insertPreparedStatement = connection.prepareStatement(insertSql);
            insertPreparedStatement.setString(1, student.getName());
            insertPreparedStatement.setString(2, student.getSchool());
            insertPreparedStatement.execute();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    @Override
    public int delete(int id) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            // Insert data
            String deleteSql = "delete from student where id = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    @Override
    public int update(String name, int id) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            // Insert data
            String insertSql = "update student set name = ? where id =?";
            PreparedStatement insertPreparedStatement = connection.prepareStatement(insertSql);
            insertPreparedStatement.setString(1, name);
            insertPreparedStatement.setInt(2, id);
            insertPreparedStatement.execute();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    @Override
    public StudentDO select(int id) {
        Connection connection = null;
        StudentDO studentDO = new StudentDO();
        try {
            connection = dataSource.getConnection();
            // Insert data
            String sql = "select name,school from student where id = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            studentDO.setName(resultSet.getString("name"));
            studentDO.setSchool(resultSet.getString("school"));
            resultSet.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return studentDO;
    }

    @Override
    public List<StudentDO> selectList(String school) {
        return null;
    }

    @Override
    public PageList selectWithPaging(String school, int pageSize, int pageNum) {
        return null;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}

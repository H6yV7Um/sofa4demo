/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.alipay.dalgen.common.dal;

import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author yinywf
 * @version $Id: JdbcSample, v 0.1 2018-06-07 20:07 yinywf Exp $
 */
@Component
public class JdbcSample {


    private DataSource dataSource;

    public void doJdbc() throws SQLException {

        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            // Insert data
            String insertSql = "INSERT INTO student ( name,school) values (?, ?)";
            PreparedStatement insertPreparedStatement = connection.prepareStatement(insertSql);
            insertPreparedStatement.setString(1, "yinywf");
            insertPreparedStatement.setString(2, "NJU");
            insertPreparedStatement.execute();

            insertSql = "INSERT INTO student ( name,school) values (?, ?)";
            insertPreparedStatement = connection.prepareStatement(insertSql);
            insertPreparedStatement.setString(1, "yinywf");
            insertPreparedStatement.setString(2, "NJU");
            insertPreparedStatement.execute();

            // Query data
            System.err.println("Query user table: ");
            // use name shard DB, id shard table
            String selectSql = "select * from student where id = ? and name = ?";
            PreparedStatement queryPreparedStatement = connection.prepareStatement(selectSql);
            queryPreparedStatement.setInt(1, 1);
            queryPreparedStatement.setString(2, "yinywf");
            ResultSet resultSet = queryPreparedStatement.executeQuery();
            while (resultSet.next()) {
                System.err.print("  id:" + resultSet.getInt(1) + ", ");
                System.err.println("name:" + resultSet.getString(2));
            }
            queryPreparedStatement = connection.prepareStatement(selectSql);
            queryPreparedStatement.setInt(1, 2);
            queryPreparedStatement.setString(2, "yinywf");
            resultSet = queryPreparedStatement.executeQuery();
            while (resultSet.next()) {
                System.err.print("  id:" + resultSet.getInt(1) + ", ");
                System.err.println("name:" + resultSet.getString(2));
            }

            // Clean data
            System.err.println("Delete user table");
            String deleteSql = "delete from student where id = ? and name = ?";
            PreparedStatement deletePreparedStatement = connection.prepareStatement(deleteSql);
            deletePreparedStatement.setInt(1, 1);
            deletePreparedStatement.setString(2, "yinywf");
            deletePreparedStatement.executeUpdate();
            deletePreparedStatement = connection.prepareStatement(deleteSql);
            deletePreparedStatement.setInt(1, 2);
            deletePreparedStatement.setString(2, "yinywf");
            deletePreparedStatement.executeUpdate();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}

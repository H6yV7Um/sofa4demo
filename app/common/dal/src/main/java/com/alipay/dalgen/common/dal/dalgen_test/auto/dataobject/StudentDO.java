/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.alipay.dalgen.common.dal.dalgen_test.auto.dataobject;

/**
 * A data object class directly models database table <tt>student</tt>.
 * <p>
 * This file is generated by <tt>dalgen-dalgen</tt>, a DAL (Data Access Layer)
 * code generation utility specially developed for <tt>dalgen</tt> project.
 * <p>
 * PLEASE DO NOT MODIFY THIS FILE MANUALLY, or else your modification may
 * be OVERWRITTEN by someone else. To modify the file, you should go to directory <tt>dalgen</tt>,
 * and find the corresponding configuration file (<tt>tables/student.xml</tt>).
 * Modify the configuration file according to your needs, then run <tt>dalgen-dalgen</tt> to generate this file.
 */
public class StudentDO {

    //========== properties ==========

    /**
     * This property corresponds to db column <tt>id</tt>.
     */
    private int id;

    /**
     * This property corresponds to db column <tt>name</tt>.
     */
    private String name;

    /**
     * This property corresponds to db column <tt>school</tt>.
     */
    private String school;

    //========== getters and setters ==========

    /**
     * Getter method for property <tt>id</tt>.
     *
     * @return property value of id
     */
    public int getId() {
        return id;
    }

    /**
     * Setter method for property <tt>id</tt>.
     *
     * @param id value to be assigned to property id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter method for property <tt>name</tt>.
     *
     * @return property value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for property <tt>name</tt>.
     *
     * @param name value to be assigned to property name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for property <tt>school</tt>.
     *
     * @return property value of school
     */
    public String getSchool() {
        return school;
    }

    /**
     * Setter method for property <tt>school</tt>.
     *
     * @param school value to be assigned to property school
     */
    public void setSchool(String school) {
        this.school = school;
    }

    /**
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return "StudentDO{" +
                "name='" + name + '\'' +
                ", school='" + school + '\'' +
                '}';
    }
}

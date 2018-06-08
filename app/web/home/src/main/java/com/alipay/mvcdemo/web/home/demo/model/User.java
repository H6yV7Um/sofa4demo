package com.alipay.mvcdemo.web.home.demo.model;



/**
 *
 * @author kevin.luy
 */
public class User {

    private int    id;
    private String name;
    private String email;

    public int getId() {
        return id;
    }

    public User setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }
}

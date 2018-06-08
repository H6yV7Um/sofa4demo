/**
 * Alipay.com Inc.
 * Copyright (c) 2005-2010 All Rights Reserved.
 */
package com.alipay.mvcdemo.web.home.demo.controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.ui.ModelMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ModelAttribute;
import com.alipay.mvcdemo.web.home.demo.model.User;

public class UsersController {
//    private Log logger=LogFactory.getLog(UsersController.class);

    private List<User> users = new ArrayList<User>();

    @ModelAttribute
    public void forTile(Map<String, Integer> map) {
        map.put("uid", 123); //渲染用户tile片段。id数字没实际意义。
    }
    
    //GET  /users
    public void doIndex(ModelMap model) {
        User xm = new User().setId(1).setEmail("xx").setName("xiaoming");
        User xg = new User().setId(2).setEmail("xx").setName("xiaogang");
        users.add(xm);
        users.add(xg);
        model.put("users", users);
    }

    //GET /users/new
    public void doNew(ModelMap model) {
        User demo = new User().setName("x").setEmail("x@yy.zz");
        model.put("user", demo);
    }

    //POST /users
    public void doCreate(ModelMap model, User user) {
        users.add(user);
    }

    //GET /users/:id
    public String doShow(ModelMap model, Integer id) {
        User user = new User().setId(id).setEmail("xx").setName("xiaoming");
        model.put("user", user);
        //return "show.vm";
        return null;
    }

    //GET /users/:id/edit
    public void doEdit(ModelMap model, Integer id) {
        User user = new User().setId(id).setEmail("xx").setName("xiaoming");
        model.put("user", user);
    }

    //PUT  /users/:id
    public void doUpdate(ModelMap model, Integer id, User user) {
        user.setId(id);
        model.put("user", user);
        //TODO  old<=user

    }

    //DELETE  /users/:id
    public void doDestroy(ModelMap model,Integer id) {
        //users.remove(id);
    	//mock
        User user = new User().setName("x").setEmail("x@yy.zz");
        model.put("user", user);

    }
}

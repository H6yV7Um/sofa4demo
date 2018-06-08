/**
 * Alipay.com Inc.
 * Copyright (c) 2005-2010 All Rights Reserved.
 */
package com.alipay.mvcdemo.web.home.demo.tile;


import org.springframework.ui.ModelMap;

import com.alipay.mvcdemo.web.home.demo.model.User;

public class UserInfoTile {


    public void  render(ModelMap model,Integer userId) {
    	model.put("user", new User().setId(userId).setName("jack").setEmail("jack@alipay.com"));

    }

}
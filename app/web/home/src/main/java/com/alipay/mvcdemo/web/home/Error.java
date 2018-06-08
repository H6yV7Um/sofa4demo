/**
 * Alipay.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.alipay.mvcdemo.web.home;

import javax.servlet.RequestDispatcher;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.WebRequest;

import com.alipay.web.mvc.common.exception.ExceptionConstants;


@Controller
public class Error {

    @RequestMapping(value = "/error")
    public void renderError(ModelMap modelMap, NativeWebRequest webReq, String exception_marking,
                            String messageCode, String exceptionCode) {
        initModelMap(modelMap, exception_marking, messageCode, exceptionCode);
        Object status = null;

        if ((status = webReq.getAttribute(RequestDispatcher.ERROR_STATUS_CODE,
            WebRequest.SCOPE_REQUEST)) != null) {
            modelMap.put(ExceptionConstants.MESSAGE_CODE_NAME, status);
            modelMap.put(ExceptionConstants.EXCEPTION_CODE_NAME, status);
            modelMap.put(ExceptionConstants.EXCEPTION_MARKING,
                webReq.getAttribute(RequestDispatcher.ERROR_MESSAGE, WebRequest.SCOPE_REQUEST));

        }
    }

    @RequestMapping(value = "/errorXbox.htm")
    public void renderErrorXBox(ModelMap modelMap, String exception_marking, String messageCode,
                                String exceptionCode) {
        initModelMap(modelMap, exception_marking, messageCode, exceptionCode);
    }

    /**
     * @param modelMap
     * @param request
     */
    private void initModelMap(ModelMap modelMap, String exception_marking, String messageCode,
                              String exceptionCode) {
        modelMap.put(ExceptionConstants.EXCEPTION_MARKING, exception_marking);
        modelMap.put(ExceptionConstants.MESSAGE_CODE_NAME, messageCode);
        modelMap.put(ExceptionConstants.EXCEPTION_CODE_NAME, exceptionCode);

    }
}

/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.alipay.mvcdemo.msgBroker;

import com.alipay.common.event.UniformEvent;
import com.alipay.common.event.UniformEventContext;
import com.alipay.common.event.UniformEventMessageListener;
import com.alipay.dalgen.common.dal.dalgen_test.auto.daointerface.StudentDAO;
import com.alipay.dalgen.common.dal.dalgen_test.auto.dataobject.StudentDO;
import com.alipay.sofa.runtime.api.annotation.SofaReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author yinywf
 * @version $Id: UniformEventMessageListenerImpl, v 0.1 2018-06-08 11:59 yinywf Exp $
 */
@Component(value = "uniformEventMessageListener")
public class UniformEventMessageListenerImpl implements UniformEventMessageListener {

    @SofaReference(uniqueId = "studentDao")
    private StudentDAO studentDAO;

    private static final Logger logger = LoggerFactory
            .getLogger(UniformEventMessageListenerImpl.class);

    @Override
    public void onUniformEvent(UniformEvent message, UniformEventContext context) throws Exception {
        // 获取topic，eventcode和payload
        final String topic = message.getTopic();
        final String eventcode = message.getEventCode();
        final Object payload = message.getEventPayload();

        System.out.println(payload);
        StudentDO studentDO = (StudentDO) payload;

        logger.info("[Receive a message] topic {} eventcode {} eventId {} payload {}", new Object[]{topic, eventcode, message.getId(), payload});
        try {
            studentDAO.insert(studentDO);
            boolean processSuccess = processMessage(message);
            if (!processSuccess) {
                // 处理消息失败，设置回滚原因并主动回滚，消息会被重新投递。
                context.setContextDesc("process error cause");
                context.setRollbackOnly();
            }
        } catch (Exception e) {
            logger.error("[Process a message, failure] topic {} eventcode {} eventId {} error {}",
                    new Object[]{topic, eventcode, message.getId(), e.getMessage()});
            // 处理消息异常，抛出异常，消息会被重新投递。
            throw e;
        }
    }

    // 处理接收到的消息
    private boolean processMessage(UniformEvent message) {
        return true;
    }

    public Object getMessage(UniformEvent message) {
        return message.getEventPayload();
    }
}
/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.alipay.mvcdemo.msgBroker;

import com.alipay.common.event.UniformEvent;
import com.alipay.common.event.UniformEventBuilder;
import com.alipay.common.event.UniformEventPublisher;
import com.alipay.common.event.impl.DefaultUniformEventBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author yinywf
 * @version $Id: UniformEventPublisherService, v 0.1 2018-06-08 11:54 yinywf Exp $
 */
@Component(value = "uniformEventPublisherService")
public class UniformEventPublisherService {

    private static final Logger logger = LoggerFactory.getLogger(UniformEventPublisherService.class);

    private UniformEventPublisher uniformEventPublisher;

    private UniformEventBuilder uniformEventBuilder = new DefaultUniformEventBuilder();

    // 发布消息，消息类型由topic和eventcode指定，业务对象作为消息负载。
    public boolean publicUniformEvent(String topic, String eventcode, Object payload) {
        // 创建消息，第一个参数是topic, 第二个参数是eventcode
        final UniformEvent uniformEvent = uniformEventBuilder.buildUniformEvent(topic, eventcode);
        // 设置消息负载,一般为业务对象
        uniformEvent.setEventPayload(payload);
        // 设置发消息失败抛出运行时异常
        uniformEvent.setThrowExceptionOnFailed(true);
        try {
            // 发布消息
            uniformEventPublisher.publishUniformEvent(uniformEvent);
            logger.info("[Public an uniformEvent, success] topic {} eventcode {} eventId {}", new Object[]{topic, eventcode, uniformEvent.getId()});
        } catch (Exception e) {
            logger.error(
                    "[Public an uniformEvent, failure] topic {} eventcode {} eventId {} error {}", new Object[]{topic, eventcode, uniformEvent.getId(), e.getMessage()});
            return false;
        }
        return true;
    }

    public void setUniformEventPublisher(UniformEventPublisher uniformEventPublisher) {
        this.uniformEventPublisher = uniformEventPublisher;
    }
}
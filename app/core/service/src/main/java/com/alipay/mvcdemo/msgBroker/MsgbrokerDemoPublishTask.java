package com.alipay.mvcdemo.msgBroker;

import com.alipay.common.event.UniformEvent;
import com.alipay.common.event.UniformEventPublisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class MsgbrokerDemoPublishTask {

    private static final Logger logger = LoggerFactory
            .getLogger(MsgbrokerDemoPublishTask.class);

    private String topic;

    private String eventcode;

    private int messageCount = 1;

    private int initDelayInSecond = 10;

    private ScheduledExecutorService scheduledExecutorService;

    private UniformEventPublisher msgbrokerDemoPublisher;

    public void init() {
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        final ScheduledFuture<?> schedule = scheduledExecutorService.schedule(new PublishMessageTask(), initDelayInSecond,
                TimeUnit.SECONDS);
        if (logger.isInfoEnabled()) {
            logger.info(
                    "schedule the publishMessageTask, done. initDelayInSecond [{}] topic [{}] eventcode [{}] messageCount [{}]",
                    new Object[]{initDelayInSecond, topic, eventcode, messageCount});
        }

    }

    private class PublishMessageTask implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < messageCount; i++) {
                publishMessage();
            }
        }

        private void publishMessage() {
            UniformEvent message = msgbrokerDemoPublisher.constructUniformEvent(eventcode, topic);
            message.setProperty("appname", "mvcdemo");
            message.setEventPayload("hello msgBroker");

            try {
                msgbrokerDemoPublisher.publishUniformEvent(message);
                if (logger.isInfoEnabled()) {
                    logger.info("[Publish Message] message [{}]", message);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setEventcode(String eventcode) {
        this.eventcode = eventcode;
    }

    public void setMessageCount(int messageCount) {
        this.messageCount = messageCount;
    }

    public void setInitDelayInSecond(int initDelayInSecond) {
        this.initDelayInSecond = initDelayInSecond;
    }

    public void setMsgbrokerDemoPublisher(UniformEventPublisher msgbrokerDemoPublisher) {
        this.msgbrokerDemoPublisher = msgbrokerDemoPublisher;
    }
}

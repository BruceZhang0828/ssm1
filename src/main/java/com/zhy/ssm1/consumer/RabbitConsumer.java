package com.zhy.ssm1.consumer;

import cn.hutool.core.lang.Console;
import com.zhy.ssm1.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitConsumer {
    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void consumeMessage(String message){
        Console.log("consume message {}", message);
    }
}

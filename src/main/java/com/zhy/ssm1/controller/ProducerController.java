package com.zhy.ssm1.controller;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.lang.Console;
import com.zhy.ssm1.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {
    @Autowired
    private RabbitTemplate  rabbitTemplate;

    @RequestMapping("/sendMessage")
    public Object sendMessage(){
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                String value = new DateTime().toString("yyyy-MM-dd HH:mm:ss");
                Console.log("send message {}", value);
                rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.ROUTING_KEY, value);
            }
        }).start();
        return "ok";
    }
}

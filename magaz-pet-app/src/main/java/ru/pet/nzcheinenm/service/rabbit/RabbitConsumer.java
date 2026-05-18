package ru.pet.nzcheinenm.service.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class RabbitConsumer {
    @RabbitListener(queues = "queue_rq")
    public void consumeMessage(String message) {
        System.out.println("Received message: " + message);
    }
}

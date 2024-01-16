package br.com.cronos.bitabit.threadasync.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class RabbitService {

    private final RabbitTemplate rabbitTemplate;

    public void sendMessage(String queueName, Object message) {
        log.info("SEND message in queue: {}", queueName);
        this.rabbitTemplate.convertAndSend(queueName, message);
    }
}

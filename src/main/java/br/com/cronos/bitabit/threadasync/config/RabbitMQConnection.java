package br.com.cronos.bitabit.threadasync.config;

import br.com.cronos.bitabit.threadasync.domain.constants.QueueName;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RabbitMQConnection {
    private static final String NAME_EXCHANGE = "amq.direct";

    private final AmqpAdmin amqpAdmin;

    private Queue queue(String queueName) {
        return new Queue(queueName, true, false, false);
    }

    private DirectExchange changeDirect() {
        return new DirectExchange(NAME_EXCHANGE);
    }

    private Binding bindingQueue(Queue queue, DirectExchange directExchange) {
        return new Binding(queue.getName(), Binding.DestinationType.QUEUE, directExchange.getName(), queue.getName(), null);
    }

    @PostConstruct
    private void add() {
        Queue queueStok = this.queue(QueueName.STOK.name().toUpperCase());
        Queue queuePrice = this.queue(QueueName.PRICE.name().toUpperCase());

        DirectExchange directExchange = this.changeDirect();

        Binding bindingQueueStok = this.bindingQueue(queueStok, directExchange);
        Binding bindingQueuePrice = this.bindingQueue(queuePrice, directExchange);

        // Create queues in Rabbit
        this.amqpAdmin.declareQueue(queueStok);
        this.amqpAdmin.declareQueue(queuePrice);

        this.amqpAdmin.declareExchange(directExchange);

        this.amqpAdmin.declareBinding(bindingQueueStok);
        this.amqpAdmin.declareBinding(bindingQueuePrice);
    }
}

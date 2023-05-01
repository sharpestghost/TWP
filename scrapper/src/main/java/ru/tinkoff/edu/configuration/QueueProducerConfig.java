package ru.tinkoff.edu.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import ru.tinkoff.edu.service.LinkChatService;
import ru.tinkoff.edu.service.sender.ScrapperQueueProducer;
import ru.tinkoff.edu.service.sender.SendUpdater;

public class QueueProducerConfig {
    @Bean
    public SendUpdater linkUpdateSender(RabbitTemplate template, LinkChatService linkService, Queue queue) {
        return new ScrapperQueueProducer( template, linkService, queue);
    }
}

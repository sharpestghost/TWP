package ru.tinkoff.edu.service.recipient;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import ru.tinkoff.edu.bot.logic.Bot;
import ru.tinkoff.edu.scrapperlink.dto.request.LinkUpdate;

@RabbitListener(queues = "${app.queue-name}")
public class ScrapperQueueRecipient extends UpdateRecipient {
    public ScrapperQueueRecipient(Bot bot) {
        super(bot);
    }

    @RabbitHandler
    @Override
    public void recieveUpdate(LinkUpdate request) {
        this.sendUpdates(request);
    }

}

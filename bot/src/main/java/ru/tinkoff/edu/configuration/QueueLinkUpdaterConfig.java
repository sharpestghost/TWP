package ru.tinkoff.edu.configuration;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import ru.tinkoff.edu.bot.logic.Bot;
import ru.tinkoff.edu.service.recipient.ScrapperQueueRecipient;
import ru.tinkoff.edu.service.recipient.UpdateRecipient;

@AutoConfiguration
@ConditionalOnProperty(prefix = "app", name = "use-queue", havingValue = "true")
public class QueueLinkUpdaterConfig {
    @Bean
    public UpdateRecipient linkUpdateReceiver(
        Bot bot
    ) {
        return new ScrapperQueueRecipient(bot);
    }
}

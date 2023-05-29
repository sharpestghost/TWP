package ru.tinkoff.edu.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.tinkoff.edu.bot.logic.Bot;
import ru.tinkoff.edu.service.recipient.HttpLinkRecipient;
import ru.tinkoff.edu.service.recipient.UpdateRecipient;

@Configuration
@ConditionalOnProperty(prefix = "app", name = "use-queue", havingValue = "false")
public class HttpLinkUpdaterConfig {
    @Bean
    public UpdateRecipient linkUpdateReceiver(
        Bot bot
    ) {
        return new HttpLinkRecipient(bot);
    }
}

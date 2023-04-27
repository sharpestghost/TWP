package ru.tinkoff.edu.configuration;

import org.jooq.DSLContext;
import org.springframework.context.annotation.Bean;

import ru.tinkoff.edu.service.ChatService;
import ru.tinkoff.edu.service.LinkChatService;
import ru.tinkoff.edu.service.LinkService;
import ru.tinkoff.edu.service.jooq.JooqChatService;
import ru.tinkoff.edu.service.jooq.JooqLinkChatService;
import ru.tinkoff.edu.service.jooq.JooqLinkService;

public class JooqAccessConfig {
    @Bean
    public LinkService linkService(DSLContext context) {
        return new JooqLinkService(context);
    }

    @Bean
    public ChatService chatService(DSLContext context) {
        return new JooqChatService(context);
    }

    @Bean
    public LinkChatService linkChatService(DSLContext context) {
        return new JooqLinkChatService(context);
    }
}

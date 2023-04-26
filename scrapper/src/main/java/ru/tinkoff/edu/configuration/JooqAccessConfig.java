package ru.tinkoff.edu.configuration;

import org.springframework.context.annotation.Bean;
import ru.tinkoff.edu.domain.jdbc.repo.ChatRepo;
import ru.tinkoff.edu.domain.jdbc.repo.LinkChatRepo;
import ru.tinkoff.edu.domain.jdbc.repo.LinkRepo;
import ru.tinkoff.edu.service.ChatService;
import ru.tinkoff.edu.service.LinkChatService;
import ru.tinkoff.edu.service.LinkService;
import ru.tinkoff.edu.service.jdbc.JdbcChatService;
import ru.tinkoff.edu.service.jdbc.JdbcLinkChatService;
import ru.tinkoff.edu.service.jdbc.JdbcLinkService;
import ru.tinkoff.edu.service.jooq.JooqChatService;
import ru.tinkoff.edu.service.jooq.JooqLinkChatService;
import ru.tinkoff.edu.service.jooq.JooqLinkService;

public class JooqAccessConfig {
    @Bean
    public LinkService linkService(LinkRepo linkRepo, ChatRepo chatRepo) {
        return new JooqLinkService();
    }

    @Bean
    public ChatService chatService(ChatRepo chatRepo) {
        return new JooqChatService();
    }

    @Bean
    public LinkChatService linkChatService(LinkChatRepo linkChatRepo) {
        return new JooqLinkChatService();
    }
}

package ru.tinkoff.edu.service.updaters;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.tinkoff.edu.client.BotClient;
import ru.tinkoff.edu.domain.repo.LinkChatRepo;
import ru.tinkoff.edu.dto.request.LinkUpdate;
import ru.tinkoff.edu.entity.Chat;
import ru.tinkoff.edu.entity.Follow;
import ru.tinkoff.edu.entity.Link;
import ru.tinkoff.edu.service.LinkChatService;
import ru.tinkoff.edu.service.jdbc.JdbcLinkChatService;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BotUpdater {
    private final LinkChatService linkChatService;
    private final BotClient botClient;
    private static final String UPDATE_OK = "Update completed.";

    public void postUpdate(Link link) {
        //temp solution
        List<Long> chatIds = new ArrayList<>();
        List<Chat> chats = linkChatService.getChatsByLink(link.getId());
        chats.forEach((Chat c) -> chatIds.add(c.getId()));
        LinkUpdate request = new LinkUpdate(link.getId(), URI.create(link.getURL()), UPDATE_OK,
                chatIds);
        botClient.postUpdate(request);
    }
}

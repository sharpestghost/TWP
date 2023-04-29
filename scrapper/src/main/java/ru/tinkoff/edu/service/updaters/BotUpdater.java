package ru.tinkoff.edu.service.updaters;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.tinkoff.edu.client.BotClient;
import ru.tinkoff.edu.dto.request.LinkUpdate;
import ru.tinkoff.edu.entity.Chat;
import ru.tinkoff.edu.entity.Link;
import ru.tinkoff.edu.service.LinkChatService;

import java.net.URI;

@AllArgsConstructor
@Service
public class BotUpdater {
    private final BotClient botClient;
    private final LinkChatService linkChatService;
    private static final String UPDATE_OK = "Update completed.";

    public void postUpdate(Link link) {
        LinkUpdate request = new LinkUpdate(link.getId(), URI.create(link.getURL()), UPDATE_OK,
                linkChatService.getChatsByLink(link.getId()).stream().map(Chat::getId).toArray(Long[]::new));
        botClient.postUpdate(request);
    }
}

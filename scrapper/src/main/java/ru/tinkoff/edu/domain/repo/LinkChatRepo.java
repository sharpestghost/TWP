package ru.tinkoff.edu.domain.repo;

import ru.tinkoff.edu.entity.Chat;
import ru.tinkoff.edu.entity.Link;
import ru.tinkoff.edu.entity.LinkChat;

import java.util.List;

public interface LinkChatRepo extends QueryRepo<LinkChat> {
    List<Link> getLinksByChatId(long chatId);
    void untrack(long chatId, long linkId);
    List<Chat> getChatsByLinkId(long linkId);
}

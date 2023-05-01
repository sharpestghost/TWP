package ru.tinkoff.edu.domain.repo;

import org.springframework.stereotype.Repository;
import ru.tinkoff.edu.entity.Chat;
import ru.tinkoff.edu.entity.Link;
import ru.tinkoff.edu.entity.LinkChat;

import java.util.List;

@Repository
public interface LinkChatRepo extends QueryRepo<LinkChat> {
    List<Link> getLinksByChatId(long chatId);
    Link track(long chatId, String url);
    Link untrack(long chatId, String url);
    List<Chat> getChatsByLinkId(long linkId);
}

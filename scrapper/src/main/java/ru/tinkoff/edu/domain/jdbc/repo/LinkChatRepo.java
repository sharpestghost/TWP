package ru.tinkoff.edu.domain.jdbc.repo;

import ru.tinkoff.edu.hw5_tempfolder.entity.Chat;
import ru.tinkoff.edu.hw5_tempfolder.entity.Link;
import ru.tinkoff.edu.hw5_tempfolder.entity.LinkChat;

import java.util.List;

public interface LinkChatRepo extends QueryRepo<LinkChat> {
    List<Link> getLinksByChatId(long chatId);
    void untrack(long chatId, long linkId);
    List<Chat> getChatsByLinkId(long linkId);
}

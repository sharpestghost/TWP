package ru.tinkoff.edu.service.jooq;

import ru.tinkoff.edu.exception.InvalidInputDataException;
import ru.tinkoff.edu.hw5_tempfolder.entity.Chat;
import ru.tinkoff.edu.hw5_tempfolder.entity.Link;
import ru.tinkoff.edu.hw5_tempfolder.entity.LinkChat;
import ru.tinkoff.edu.service.ChatService;
import ru.tinkoff.edu.service.LinkChatService;

import java.util.List;

public class JooqLinkChatService implements LinkChatService {
    //TODO
    @Override
    public void add(LinkChat linkChat) throws InvalidInputDataException {

    }

    @Override
    public void remove(LinkChat linkChat) {

    }

    @Override
    public List<LinkChat> findAll() {
        return null;
    }

    @Override
    public List<Link> getLinksByChatId(long chatId) {
        return null;
    }

    @Override
    public List<Chat> getChatsByLink(long linkId) {
        return null;
    }
}

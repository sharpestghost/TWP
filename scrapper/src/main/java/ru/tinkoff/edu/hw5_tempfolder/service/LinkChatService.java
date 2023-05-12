package ru.tinkoff.edu.hw5_tempfolder.service;

import ru.tinkoff.edu.exception.InvalidInputDataException;
import ru.tinkoff.edu.hw5_tempfolder.entity.Chat;
import ru.tinkoff.edu.hw5_tempfolder.entity.Link;
import ru.tinkoff.edu.hw5_tempfolder.entity.LinkChat;

import java.util.List;

public interface LinkChatService {
    void add(LinkChat linkChat) throws InvalidInputDataException;
    void remove(LinkChat linkChat);
    List<LinkChat> findAll();
    List<Link> getLinksByChatId(long chatId);
    List<Chat> getChatsByLink(long linkId);
}

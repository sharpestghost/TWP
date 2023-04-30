package ru.tinkoff.edu.service;

import ru.tinkoff.edu.entity.Follow;
import ru.tinkoff.edu.exception.InvalidInputDataException;
import ru.tinkoff.edu.entity.Chat;
import ru.tinkoff.edu.entity.Link;
import ru.tinkoff.edu.entity.LinkChat;

import java.util.List;

public interface LinkChatService<T> {
    void add(T linkChat) throws InvalidInputDataException;
    void remove(T linkChat);
    List<T> findAll();
    List<Link> getLinksByChatId(long chatId);
    List<Chat> getChatsByLink(long linkId);
}

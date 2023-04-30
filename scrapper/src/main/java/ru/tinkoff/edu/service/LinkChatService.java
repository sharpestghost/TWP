package ru.tinkoff.edu.service;

import ru.tinkoff.edu.exception.InvalidInputDataException;
import ru.tinkoff.edu.entity.Chat;
import ru.tinkoff.edu.entity.Link;

import java.util.List;

public interface LinkChatService<T> {
    void add(T linkChat) throws InvalidInputDataException;
    void untrack(T linkChat);
    List<T> findAll();
    List<Link> getLinksByChatId(long chatId);
    List<Chat> getChatsByLink(long linkId);
}

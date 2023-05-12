package ru.tinkoff.edu.hw5_tempfolder.service;

import ru.tinkoff.edu.exception.InvalidInputDataException;
import ru.tinkoff.edu.hw5_tempfolder.entity.Chat;
import ru.tinkoff.edu.hw5_tempfolder.entity.Link;

import java.util.List;

public interface ChatService {
    void register(long tgChatId, String name, String description) throws InvalidInputDataException;
    void unregister(long tgChatId);
    Chat getById(long tgChatId);
    List<Chat> findAll();
    List<Link> getLinksByChat(long chatId);
}

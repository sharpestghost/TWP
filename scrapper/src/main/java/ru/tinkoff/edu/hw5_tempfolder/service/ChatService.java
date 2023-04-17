package ru.tinkoff.edu.hw5_tempfolder.service;

import ru.tinkoff.edu.exception.InvalidInputDataException;

public interface ChatService {
    void register(long tgChatId, String name, String description) throws InvalidInputDataException;
    void unregister(long tgChatId);
}

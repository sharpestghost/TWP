package ru.tinkoff.edu.service.jooq;

import ru.tinkoff.edu.exception.InvalidInputDataException;
import ru.tinkoff.edu.hw5_tempfolder.entity.Chat;
import ru.tinkoff.edu.hw5_tempfolder.entity.Link;
import ru.tinkoff.edu.service.ChatService;

import java.util.List;

public class JooqChatService implements ChatService {

    //TODO
    @Override
    public void register(long tgChatId, String name, String description) throws InvalidInputDataException {
    }

    @Override
    public void unregister(long tgChatId) {

    }

    @Override
    public Chat getById(long tgChatId) {
        return null;
    }

    @Override
    public List<Chat> findAll() {
        return null;
    }

    @Override
    public List<Link> getLinksByChat(long chatId) {
        return null;
    }
}

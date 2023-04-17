package ru.tinkoff.edu.hw5_tempfolder.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import ru.tinkoff.edu.exception.InvalidInputDataException;
import ru.tinkoff.edu.hw5_tempfolder.entity.Chat;
import ru.tinkoff.edu.hw5_tempfolder.repo.impl.ChatImpl;
import ru.tinkoff.edu.hw5_tempfolder.service.ChatService;

@RequiredArgsConstructor
public class JdbcChatService implements ChatService {
    private final ChatImpl chatImpl;

    @Override
    public void unregister(long chatId) {
        chatImpl.remove(chatId);
    }

    @Override
    public void register(long chatId, String name, String description) throws InvalidInputDataException {
        Chat chat = new Chat();
        if (name == null || description == null) {
            throw new InvalidInputDataException();
        }
        chat.setId(chatId);
        chat.setChatName(name);
        chat.setDescription(description);
        try {
            chatImpl.add(chat);
        } catch (DuplicateKeyException e) {
            throw new InvalidInputDataException("duplicate primary key error");
        }
    }


}

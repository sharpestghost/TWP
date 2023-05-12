package ru.tinkoff.edu.hw5_tempfolder.service.jdbc;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ru.tinkoff.edu.exception.InvalidInputDataException;
import ru.tinkoff.edu.hw5_tempfolder.entity.Chat;
import ru.tinkoff.edu.hw5_tempfolder.entity.Link;
import ru.tinkoff.edu.hw5_tempfolder.repo.ChatRepo;
import ru.tinkoff.edu.hw5_tempfolder.repo.impl.ChatImpl;
import ru.tinkoff.edu.hw5_tempfolder.service.ChatService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JdbcChatService implements ChatService {
    private final ChatRepo chatRepo;

    @Override
    public void register(long chatId, String name, String description) throws InvalidInputDataException {
        Chat chat = new Chat();
        chat.setId(chatId);
        chat.setChatName(name);
        chat.setDescription(description);
        chatRepo.add(chat);
    }

    @Override
    public void unregister(long chatId) {
        chatRepo.remove(chatId);
    }

    @Override
    public Chat getById(long chatId) {
        return chatRepo.get(chatId);
    }

    @Override
    public List<Link> getLinksByChat(long chatId) {
        return chatRepo.findAllLinks(chatId);
    }

    @Override
    public List<Chat> findAll() {
        return chatRepo.findAll();
    }


}

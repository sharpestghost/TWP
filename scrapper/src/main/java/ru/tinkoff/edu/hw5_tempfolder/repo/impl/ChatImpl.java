package ru.tinkoff.edu.hw5_tempfolder.repo.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.tinkoff.edu.exception.InvalidInputDataException;
import ru.tinkoff.edu.hw5_tempfolder.entity.Chat;
import ru.tinkoff.edu.hw5_tempfolder.repo.ChatRepo;
import java.util.List;

@RequiredArgsConstructor
public class ChatImpl implements ChatRepo {
    private final JdbcTemplate template;
    private final RowMapper<Chat> rowMapper = new DataClassRowMapper<>(Chat.class);

    private static final String ADD_CHAT = "INSERT INTO chat(id, chatname, description) VALUES (?, ?, ?)";
    private static final String SELECT_ALL = "SELECT * FROM chat";
    private static final String REMOVE_BY_ID = "DELETE FROM chat WHERE id=?";
    private static final String REMOVE_BY_NAME = "DELETE FROM chat WHERE chatname=?";
    @Override
    public void add(Chat chat) throws InvalidInputDataException {
        if (chat == null) {
            throw new InvalidInputDataException();
        }
        Long id = chat.getId();
        String name = chat.getChatName();
        String description = chat.getDescription();
        if (id == null || name == null || description == null) {
            throw new InvalidInputDataException();
        }
        template.update(ADD_CHAT, id, name, description);
    }

    @Override
    public void remove(long id) {
        template.update(REMOVE_BY_ID, id);
    }

    @Override
    public void remove(String name) {
        template.update(REMOVE_BY_NAME, name);
    }

    @Override
    public List<Chat> findAll() {
        return template.query(SELECT_ALL, rowMapper);
    }
}

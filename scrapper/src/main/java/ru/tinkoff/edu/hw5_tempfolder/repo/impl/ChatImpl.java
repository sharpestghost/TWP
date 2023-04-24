package ru.tinkoff.edu.hw5_tempfolder.repo.impl;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ru.tinkoff.edu.exception.InvalidInputDataException;
import ru.tinkoff.edu.hw5_tempfolder.entity.Chat;
import ru.tinkoff.edu.hw5_tempfolder.entity.Link;
import ru.tinkoff.edu.hw5_tempfolder.repo.ChatRepo;
import ru.tinkoff.edu.hw5_tempfolder.service.ChatService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

@Repository
@AllArgsConstructor
public class ChatImpl implements ChatRepo {
    private final JdbcTemplate template;
    private final RowMapper<Chat> rowMapper = new DataClassRowMapper<>(Chat.class);
    private final RowMapper<Link> linkRowMapper = new DataClassRowMapper<>(Link.class);

    private static final String ADD_CHAT = "INSERT INTO chat(id, chatname, description) VALUES (?, ?, ?)";
    private static final String SELECT_ALL = "SELECT * FROM chat";
    private static final String SELECT_BY_ID = "SELECT * FROM chat WHERE id=?";
    private static final String REMOVE_BY_ID = "DELETE FROM chat WHERE id=?";
    private static final String REMOVE_BY_NAME = "DELETE FROM chat WHERE chatname=?";
    private static final String SELECT_LINKS = "SELECT l.id id, l.linkname linkname, l.url url, l.description description, l.updated_at updated_at" +
            " FROM link l INNER JOIN link_chat lc WHERE lc.chat_id = ?";
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
    public Chat get(long chatId) {
        return template.queryForObject(SELECT_BY_ID, rowMapper, chatId);

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

    @Override
    public List<Link> findAllLinks(long id) {
        template.update(SELECT_LINKS, id);
        return template.query(SELECT_LINKS, linkRowMapper);
    }
}

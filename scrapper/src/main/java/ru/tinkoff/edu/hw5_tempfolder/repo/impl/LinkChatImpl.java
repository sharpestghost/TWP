package ru.tinkoff.edu.hw5_tempfolder.repo.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.tinkoff.edu.exception.InvalidInputDataException;
import ru.tinkoff.edu.hw5_tempfolder.entity.LinkChat;
import ru.tinkoff.edu.hw5_tempfolder.repo.LinkChatRepo;

import java.sql.SQLException;
import java.util.List;

@RequiredArgsConstructor
public class LinkChatImpl implements LinkChatRepo {
    private final JdbcTemplate template;
    private final RowMapper<LinkChat> rowMapper = new DataClassRowMapper<>(LinkChat.class);
    private static final String INSERT_QUERY = "INSERT INTO chat_link(chat_id, link_id) VALUES (?, ?)";
    private static final String REMOVE_CHATLINK = "DELETE FROM chat_link WHERE chat_id=? AND link_id=?";
    private static final String SELECT_ALL = "SELECT * FROM link_chat";

    @Override
    public void add(LinkChat linkChat) throws InvalidInputDataException {
        if (linkChat == null || linkChat.getChatId() == null || linkChat.getChatId() == null) {
            throw new InvalidInputDataException();
        }
    }

    @Override
    public void remove(long chatId, long linkId) {

    }

    @Override
    public List<LinkChat> findAll() {
        return null;
    }
}

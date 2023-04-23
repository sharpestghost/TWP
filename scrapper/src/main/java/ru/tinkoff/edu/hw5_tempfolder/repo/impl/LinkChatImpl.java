package ru.tinkoff.edu.hw5_tempfolder.repo.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.tinkoff.edu.exception.InvalidInputDataException;
import ru.tinkoff.edu.hw5_tempfolder.entity.LinkChat;
import ru.tinkoff.edu.hw5_tempfolder.repo.LinkChatRepo;
import ru.tinkoff.edu.hw5_tempfolder.repo.mapper.LinkChatMapper;

import java.sql.SQLException;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class LinkChatImpl implements LinkChatRepo {
    private final JdbcTemplate template;
    private static final String INSERT_QUERY = "INSERT INTO chat_link(chat_id, link_id) VALUES (?, ?)";
    private static final String REMOVE_CHATLINK = "DELETE FROM chat_link WHERE chat_id=? AND link_id=?";
    private static final String SELECT_ALL = "SELECT * FROM link_chat";

    @Override
    public void add(LinkChat linkChat) throws InvalidInputDataException {
        long linkId = linkChat.getLinkId();
        long chatId = linkChat.getChatId();
        if (linkChat == null || linkChat.getChatId() == null || linkChat.getLinkId() == null) {
            throw new InvalidInputDataException();
        }
        int result = template.update(INSERT_QUERY, chatId, linkId);
        if (result == 0) {
            throw new InvalidInputDataException();
        }
    }

    @Override
    public void untrack(long chatId, long linkId) {
        int result = template.update(REMOVE_CHATLINK, chatId, linkId);
        if (result == 0) {
            System.out.println("Something went wrong..");
        } else {
            System.out.println("Link successfully untracked");
        }
    }

    @Override
    public List<LinkChat> findAll() {
        return template.query(SELECT_ALL, new LinkChatMapper());
    }
}

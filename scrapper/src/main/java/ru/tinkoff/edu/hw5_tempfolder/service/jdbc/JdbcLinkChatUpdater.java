package ru.tinkoff.edu.hw5_tempfolder.service.jdbc;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.tinkoff.edu.hw5_tempfolder.entity.LinkChat;
import ru.tinkoff.edu.hw5_tempfolder.service.LinkChatUpdater;

import java.util.List;
@Repository
@RequiredArgsConstructor
public class JdbcLinkChatUpdater implements LinkChatUpdater {
    private final JdbcTemplate template;
    private final RowMapper<LinkChat> rowMapper = new DataClassRowMapper<>(LinkChat.class);

    private static final String INSERT_QUERY = "INSERT INTO chat_link(chat_id, link_id) VALUES (?, ?)";
    private static final String DELETE_BY_CHAT_ID_AND_LINK_ID_QUERY = "DELETE FROM chat_link WHERE chat_id=? AND link_id=?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM chat_link";
    private static final String SELECT_BY_CHAT_ID = "SELECT * FROM chat_link WHERE chat_id=?";
    private static final String SELECT_BY_LINK_ID = "SELECT * FROM chat_link WHERE link_id=?";


    @Override
    public void add(LinkChat linkChat) {
        template.update(INSERT_QUERY, linkChat.getChatId(), linkChat.getLinkId());
    }

    @Override
    public void remove(LinkChat linkChat) {
        template.update(DELETE_BY_CHAT_ID_AND_LINK_ID_QUERY, linkChat.getChatId(), linkChat.getLinkId());
    }

    @Override
    public List<LinkChat> findAll() {
        return template.query(SELECT_ALL_QUERY, rowMapper);
    }

    @Override
    public List<LinkChat> getLinksByChatId(long chatId) {
        return template.query(SELECT_BY_CHAT_ID, rowMapper, chatId);
    }

    @Override
    public List<LinkChat> getChatsByLink(long linkId) {
        return template.query(SELECT_BY_LINK_ID, rowMapper, linkId);
    }

}

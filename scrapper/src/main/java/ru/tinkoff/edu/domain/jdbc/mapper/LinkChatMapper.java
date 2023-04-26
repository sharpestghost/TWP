package ru.tinkoff.edu.domain.jdbc.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.tinkoff.edu.hw5_tempfolder.entity.Chat;
import ru.tinkoff.edu.hw5_tempfolder.entity.Link;
import ru.tinkoff.edu.hw5_tempfolder.entity.LinkChat;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LinkChatMapper implements RowMapper<LinkChat> {
    @Override
    public LinkChat mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new LinkChat(rs.getLong("chat_id"), rs.getLong("link_id"));
    }
}

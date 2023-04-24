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
    private final JdbcTemplate template;
    private final RowMapper<Chat> rowMapper = new DataClassRowMapper<>(Chat.class);
    private final RowMapper<Link> linkRowMapper = new DataClassRowMapper<>(Link.class);

    private static final String ADD_CHAT = "INSERT INTO chat(id, chatname, description) VALUES (?, ?, ?)";
    private static final String SELECT_ALL = "SELECT * FROM chat";
    private static final String REMOVE_BY_ID = "DELETE FROM chat WHERE id=?";
    private static final String REMOVE_BY_NAME = "DELETE FROM chat WHERE chatname=?";
    private static final String SELECT_LINKS = "SELECT l.id id, l.linkname linkname, l.url url, l.description description, l.updated_at updated_at" +
            " FROM link l INNER JOIN link_chat lc WHERE lc.chat_id = ?";

    @Override
    public void register(long tgChatId, String name, String description) throws InvalidInputDataException {

    }

    @Override
    public void unregister(long tgChatId) {

    }

    @Override
    public List<Chat> getChatsForLink(Link link) {
        return null;
    }
}

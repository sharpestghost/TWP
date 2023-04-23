package ru.tinkoff.edu.hw5_tempfolder.repo.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.tinkoff.edu.exception.InvalidInputDataException;
import ru.tinkoff.edu.exception.ResultNotFoundException;
import ru.tinkoff.edu.hw5_tempfolder.entity.Chat;
import ru.tinkoff.edu.hw5_tempfolder.entity.Link;
import ru.tinkoff.edu.hw5_tempfolder.repo.LinkRepo;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class LinkImpl implements LinkRepo {
    private final JdbcTemplate template;
    private final RowMapper<Link> rowMapper = new DataClassRowMapper<>(Link.class);

    private static final String ADD_CHAT = "INSERT INTO link(id, url, linkname) VALUES (?, ?, ?)";
    private static final String SELECT_ALL = "SELECT * FROM link";
    private static final String SELECT_BY_LINK = "SELECT * FROM link WHERE url = ?";
    private static final String REMOVE_BY_ID = "DELETE FROM link WHERE id = ?";
    private static final String UPDATE_LAST_DATE = "UPDATE link SET updated_at = now() WHERE id = ?";

    @Override
    public void updateData(long linkId) {
        template.update(UPDATE_LAST_DATE, linkId);
    }

    @Override
    public Link getByLink(String url) {
        return template.queryForObject(SELECT_BY_LINK, rowMapper, url);
    }
    @Override
    public void add(Link link) throws InvalidInputDataException {
        if (link == null) {
            throw new InvalidInputDataException();
        }
        Long id = link.getId();
        String name = link.getLinkName();
        String url = link.getURL();
        if (id == null || name == null || url == null) {
            throw new InvalidInputDataException();
        }
        template.update(ADD_CHAT, id, url, name);
    }

    @Override
    public void remove(long id) {
        template.update(REMOVE_BY_ID, id);
    }

    @Override
    public List<Link> findAll() {
        return template.query(SELECT_ALL, rowMapper);
    }

}

package ru.tinkoff.edu.domain.jdbc.impl;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.tinkoff.edu.exception.DataNotFoundException;
import ru.tinkoff.edu.exception.InvalidInputDataException;
import ru.tinkoff.edu.entity.Link;
import ru.tinkoff.edu.domain.repo.LinkRepo;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;

@Repository
@AllArgsConstructor
public class LinkImpl implements LinkRepo {
    private final JdbcTemplate template;
    private final RowMapper<Link> rowMapper = new DataClassRowMapper<>(Link.class);

    private static final String ADD_CHAT = "INSERT INTO link(id, url, linkname) VALUES (?, ?, ?)";
    private static final String SELECT_ALL = "SELECT * FROM link";
    private static final String SELECT_BY_LINK = "SELECT * FROM link WHERE url = ?";
    private static final String REMOVE_BY_ID = "DELETE FROM link WHERE id = ?";
    private static final String UPDATE_LAST_DATE = "UPDATE link SET updated_at = now() WHERE id = ?";
    private static final String REMOVE_NOTFOUND = "Link not found.";

    @Override
    public void updateLinkData(long linkId) {
        int cnt = template.update(UPDATE_LAST_DATE, linkId);
        if (cnt == 0) {
            throw new DataNotFoundException(REMOVE_NOTFOUND);
        }
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
        int cnt = template.update(REMOVE_BY_ID, id);
        if (cnt == 0) {
            throw new DataNotFoundException(REMOVE_NOTFOUND);
        }
    }

    @Override
    public List<Link> findAll() {
        return template.query(SELECT_ALL, rowMapper);
    }

    public List<Link> getOldLinksListForUpdate() {
       findAll().stream().forEach(link -> System.out.println(link.getId() + " " + link.getLastUpdateDate()));
        return findAll();
    }

}

package ru.tinkoff.edu.domain.jdbc.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.tinkoff.edu.hw5_tempfolder.entity.Link;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Date;

public class LinkMapper implements RowMapper<Link> {
    @Override
    public Link mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Link(rs.getLong("id"),
                rs.getString("url"), rs.getString("linkname"), rs.getString("description"),
                getDateColumn(rs.getDate("updated_at")), rs.getInt("answerCount"));
    }

    private OffsetDateTime getDateColumn(Date date) {
        return date.toInstant().atOffset(ZoneOffset.UTC);
    }
}

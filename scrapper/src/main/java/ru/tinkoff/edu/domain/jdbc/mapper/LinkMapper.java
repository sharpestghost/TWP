package ru.tinkoff.edu.domain.jdbc.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.tinkoff.edu.entity.Link;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Component
public class LinkMapper implements RowMapper<Link> {
    @Override
    public Link mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Link(rs.getLong("id"),
                rs.getString("url"), rs.getString("linkname"), 
                getDateColumn(rs.getDate("updated_at")), rs.getInt("answerCount"));
    }

    private OffsetDateTime getDateColumn(Date date) {
        return date.toInstant().atOffset(ZoneOffset.UTC);
    }
}

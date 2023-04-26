package ru.tinkoff.edu.domain.jdbc.repo;

import ru.tinkoff.edu.exception.ResultNotFoundException;
import ru.tinkoff.edu.hw5_tempfolder.entity.Link;

import java.util.List;

public interface LinkRepo extends QueryRepo<Link> {
    void remove(long id);
    void updateLinkData(long linkId);
    Link getByLink(String link) throws ResultNotFoundException;
    List<Link> getOldLinksListForUpdate();
}

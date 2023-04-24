package ru.tinkoff.edu.hw5_tempfolder.repo;

import ru.tinkoff.edu.exception.InvalidInputDataException;
import ru.tinkoff.edu.exception.ResultNotFoundException;
import ru.tinkoff.edu.hw5_tempfolder.entity.Chat;
import ru.tinkoff.edu.hw5_tempfolder.entity.Link;
import ru.tinkoff.edu.hw5_tempfolder.entity.LinkChat;

import java.sql.SQLException;
import java.util.List;

public interface LinkRepo extends QueryRepo<Link> {
    void remove(long id);
    void updateLinkData(long linkId);
    Link getByLink(String link) throws ResultNotFoundException;
}

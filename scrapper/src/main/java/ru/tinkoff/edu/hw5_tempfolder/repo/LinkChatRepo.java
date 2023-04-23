package ru.tinkoff.edu.hw5_tempfolder.repo;

import ru.tinkoff.edu.exception.InvalidInputDataException;
import ru.tinkoff.edu.hw5_tempfolder.entity.Link;
import ru.tinkoff.edu.hw5_tempfolder.entity.LinkChat;

import java.sql.SQLException;
import java.util.List;

public interface LinkChatRepo extends QueryRepo<LinkChat> {
    void untrack(long chatId, long linkId);
}

package ru.tinkoff.edu.hw5_tempfolder.repo;

import ru.tinkoff.edu.exception.InvalidInputDataException;
import ru.tinkoff.edu.hw5_tempfolder.entity.Chat;
import ru.tinkoff.edu.hw5_tempfolder.entity.Link;

import java.util.List;

public interface ChatRepo extends QueryRepo<Chat> {
    void remove(long id);
    void remove(String name);
    Chat get(long chatId);
    List<Link> findAllLinks(long chatId);
}

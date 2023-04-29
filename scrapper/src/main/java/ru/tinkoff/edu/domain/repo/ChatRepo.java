package ru.tinkoff.edu.domain.repo;

import ru.tinkoff.edu.entity.Chat;
import ru.tinkoff.edu.entity.Link;

import java.util.List;

public interface ChatRepo extends QueryRepo<Chat> {
    void remove(long id);
    void remove(String name);
    Chat get(long chatId);
    List<Link> findAllLinks(long chatId);
}

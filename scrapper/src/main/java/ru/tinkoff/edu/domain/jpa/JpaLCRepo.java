package ru.tinkoff.edu.domain.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.tinkoff.edu.entity.Chat;
import ru.tinkoff.edu.entity.Follow;
import ru.tinkoff.edu.entity.Link;

import java.util.List;
import java.util.Optional;

public interface JpaLCRepo extends JpaRepository<Follow, Long> {
    void track(long chatId, long linkId);
    void untrack(long chatId, long linkId);
    void remove(Chat chat, Link link);
    Optional<Follow> find(Chat chat, Link link);
    @Query("select f.Chat from Follow f where f.link.id=:id")
    List<Link> getLinksByChatId(long chatId);
    @Query("select f.Link from Follow f where f.chat.id=:id")
    List<Chat> getChatsByLinkId(long linkId);
}

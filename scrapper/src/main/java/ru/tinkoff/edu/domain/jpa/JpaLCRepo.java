package ru.tinkoff.edu.domain.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.tinkoff.edu.entity.Chat;
import ru.tinkoff.edu.entity.Follow;
import ru.tinkoff.edu.entity.Link;

import java.util.List;
import java.util.Optional;

public interface JpaLCRepo extends JpaRepository<Follow, Long> {
    Optional<Follow> findByChatAndLink(Chat chat, Link link);
    @Query(value = "select f.Chat from Link_Chat f where f.link_id=:id", nativeQuery = true)
    List<Link> getLinksByChatId(long id);
    @Query(value = "select f.Link from Link_Chat f where f.chat_id=:id", nativeQuery = true)
    List<Chat> getChatsByLinkId(long id);
}

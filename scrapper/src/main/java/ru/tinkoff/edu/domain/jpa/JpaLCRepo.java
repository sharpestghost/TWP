package ru.tinkoff.edu.domain.jpa;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.tinkoff.edu.entity.Chat;
import ru.tinkoff.edu.entity.Follow;
import ru.tinkoff.edu.entity.Link;


public interface JpaLCRepo extends JpaRepository<Follow, Long> {

    @Query
    Optional<Follow> findByChatAndLink(Chat chat, Link link);

    @Query(value = "SELECT chat_id FROM link_chat where link_id = :linkId", nativeQuery = true)
    List<Long> getChatIdsByLinkId(@Param("linkId") long linkId);

    @Query(value = "SELECT link_id FROM link_chat where chat_id = :id", nativeQuery = true)
    List<Long> getLinksByChatId(long id);
}

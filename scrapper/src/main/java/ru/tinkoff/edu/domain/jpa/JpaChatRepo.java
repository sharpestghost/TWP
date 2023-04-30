package ru.tinkoff.edu.domain.jpa;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.tinkoff.edu.entity.Chat;

import java.util.Optional;

@Repository
public interface JpaChatRepo extends JpaRepository<Chat, Long> {
    Optional<Chat> findById(@NotNull Long id);
    @Query(value="insert into chat (id, chatname) values (tg_chat_id, chatname) on conflict do nothing",
            nativeQuery = true)
    void insertChat(@Param("id") Long tgChatId, @Param("chatname") String chatName);
}

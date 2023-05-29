package ru.tinkoff.edu.domain.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.tinkoff.edu.entity.Chat;

@Repository
public interface JpaChatRepo extends JpaRepository<Chat, Long> {

}

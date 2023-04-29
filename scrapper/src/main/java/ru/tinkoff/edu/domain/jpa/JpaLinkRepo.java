package ru.tinkoff.edu.domain.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.tinkoff.edu.entity.Link;

import java.util.Optional;

public interface JpaLinkRepo extends JpaRepository<Link, Long> {
    @Query("select l from Link l where l.link = :link")
    Optional<Link> findByLink(String url);


}

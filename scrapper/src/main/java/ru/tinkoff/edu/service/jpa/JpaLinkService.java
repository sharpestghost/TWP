package ru.tinkoff.edu.service.jpa;

import java.net.URI;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import ru.tinkoff.edu.converter.EntityConverter;
import ru.tinkoff.edu.domain.jpa.JpaChatRepo;
import ru.tinkoff.edu.domain.jpa.JpaLCRepo;
import ru.tinkoff.edu.domain.jpa.JpaLinkRepo;
import ru.tinkoff.edu.entity.Chat;
import ru.tinkoff.edu.entity.Follow;
import ru.tinkoff.edu.entity.Link;
import ru.tinkoff.edu.exception.InvalidInputDataException;
import ru.tinkoff.edu.service.LinkService;

@RequiredArgsConstructor
public class JpaLinkService implements LinkService {
    private final JpaChatRepo chatRepo;
    private final JpaLinkRepo linkRepo;
    private final JpaLCRepo linkChatRepo;

    @Transactional
    @Override
    public Link add(Long chatId, URI url) throws InvalidInputDataException {
        Chat chat = chatRepo.findById(chatId).orElse(null);
        boolean isPresent = linkRepo.findByLink(url.toString()).isPresent();
        Link link = isPresent ? linkRepo.findByLink(url.toString()).orElse(null)
                : linkRepo.save(EntityConverter.createLink(url));
        if (chat == null || link == null || linkChatRepo.findByChatAndLink(chat, link).isPresent()) {
            throw new InvalidInputDataException();
        }
        linkChatRepo.save(getFollow(link, chat));
        return link;
    }

    @Transactional
    @Override
    public Link remove(Long chatId, URI url) throws InvalidInputDataException {
        Chat chat = chatRepo.findById(chatId).orElse(null);
        Link link = EntityConverter.createLink(url);
        if (chat == null || link == null) {
            throw new InvalidInputDataException();
        }
        linkRepo.delete(link);
        return link;
    }

    @Transactional
    @Override
    public List<Link> listAll(Long chatId) {
        System.out.println(chatId);
        List<Long> linkIds = linkChatRepo.getLinksByChatId(chatId);
        System.out.println(linkIds.size());
        System.out.println("size:" + linkRepo.findAllById(linkIds).size());
        return linkRepo.findAllById(linkIds);
    }

    @Override
    public List<Link> listAll() {
        return linkRepo.findAll();
    }

    @Override
    public void updateLinkData(Link link) {
        linkRepo.save(link);
    }

    @Override
    public List<Link> getLinksForUpdate() {
        return linkRepo.findAll()
                .stream()
                .filter((Link l) -> l.getLastUpdateDate()
                        .isBefore(OffsetDateTime.of(LocalDateTime.now().minusHours(1), ZoneOffset.UTC)))
                .toList();
    }

    private Follow getFollow(Link link, Chat chat) {
        return new Follow(link, chat);
    }
}

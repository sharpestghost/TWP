package ru.tinkoff.edu.service.jpa;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tinkoff.edu.converter.EntityConverter;
import ru.tinkoff.edu.converter.ResponseConverter;
import ru.tinkoff.edu.domain.jpa.JpaChatRepo;
import ru.tinkoff.edu.domain.jpa.JpaLCRepo;
import ru.tinkoff.edu.domain.jpa.JpaLinkRepo;
import ru.tinkoff.edu.domain.repo.ChatRepo;
import ru.tinkoff.edu.domain.repo.LinkChatRepo;
import ru.tinkoff.edu.domain.repo.LinkRepo;
import ru.tinkoff.edu.entity.Chat;
import ru.tinkoff.edu.entity.Follow;
import ru.tinkoff.edu.entity.Link;
import ru.tinkoff.edu.exception.InvalidInputDataException;
import ru.tinkoff.edu.service.LinkService;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class JpaLinkService implements LinkService {
    private final JpaChatRepo chatRepo;
    private final JpaLinkRepo linkRepo;
    private final JpaLCRepo linkChatRepo;
    @Transactional
    @Override
    public Link add(Long chatId, URI url) throws InvalidInputDataException {
        Chat chat = chatRepo.findById(chatId).orElse(null);
        Link link = linkRepo.findByLink(url.toString()).orElseGet(
                () -> linkRepo.save(EntityConverter.createLink(url)));
        if (chat == null || linkChatRepo.find(chat, link).isPresent()) {
            throw new InvalidInputDataException();
        }
        Follow follow = new Follow();
        follow.setLink(link);
        follow.setChat(chat);
        linkChatRepo.saveAndFlush(follow);
        return null;
    }

    @Transactional
    @Override
    public Link remove(Long chatId, URI url) throws InvalidInputDataException {
        Chat chat = chatRepo.findById(chatId).orElse(null);
        Link link = linkRepo.findByLink(url.toString()).orElse(null);
        if (chat == null || link == null) {
            throw new InvalidInputDataException();
        }
        linkChatRepo.remove(chat, link);
        return link;
    }

    @Transactional
    @Override
    public List<Link> listAll(Long chatId) {
        Optional<Chat> chat = chatRepo.findById(chatId);
        return chat.map(value -> linkChatRepo.getLinksByChatId(value.getId()))
                .orElse(null);
    }

    @Override
    public List<Link> listAll() {
        return linkRepo.findAll();
    }

    @Override
    public void updateLinkData(Link link) {

    }

    @Override
    public List<Link> getLinksForUpdate() {
        return null;
    }
}

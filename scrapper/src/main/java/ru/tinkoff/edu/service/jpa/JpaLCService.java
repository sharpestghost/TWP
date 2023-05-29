package ru.tinkoff.edu.service.jpa;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import ru.tinkoff.edu.domain.jpa.JpaChatRepo;
import ru.tinkoff.edu.domain.jpa.JpaLCRepo;
import ru.tinkoff.edu.domain.jpa.JpaLinkRepo;
import ru.tinkoff.edu.entity.Chat;
import ru.tinkoff.edu.entity.Follow;
import ru.tinkoff.edu.entity.Link;
import ru.tinkoff.edu.exception.InvalidInputDataException;
import ru.tinkoff.edu.service.LinkChatService;

@RequiredArgsConstructor
public class JpaLCService implements LinkChatService<Follow> {
    private final JpaChatRepo chatRepo;
    private final JpaLinkRepo linkRepo;
    private final JpaLCRepo linkChatRepo;

    @Override
    public void add(Long chatId, String url) throws InvalidInputDataException {
        //rewrite this
    }

    @Override
    public Link untrack(Long chatId, String url) {
        Chat chat = chatRepo.findById(chatId).orElse(null);
        Link link = linkRepo.findByLink(url).orElse(null);
        if (chat == null || link == null) {
            throw new InvalidInputDataException();
        }
        linkChatRepo.findByChatAndLink(chat, link).ifPresent(linkChatRepo::delete);
        return link;
    }

    @Transactional
    @Override
    public List<Follow> findAll() {
        return linkChatRepo.findAll();
    }

    @Transactional
    @Override
    public List<Link> getLinksByChat(long chatId) {
        List<Long> linkIds = linkChatRepo.getLinksByChatId(chatId);
        return linkRepo.findAllById(linkIds);
    }

    @Transactional
    @Override
    public List<Chat> getChatsByLink(long linkId) {
        List<Long> chatIds = linkChatRepo.getChatIdsByLinkId(linkId);
        return chatRepo.findAllById(chatIds);
    }
}

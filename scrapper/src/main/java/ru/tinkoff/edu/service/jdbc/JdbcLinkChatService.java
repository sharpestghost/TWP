package ru.tinkoff.edu.service.jdbc;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.tinkoff.edu.exception.InvalidInputDataException;
import ru.tinkoff.edu.hw5_tempfolder.entity.Chat;
import ru.tinkoff.edu.hw5_tempfolder.entity.Link;
import ru.tinkoff.edu.hw5_tempfolder.entity.LinkChat;
import ru.tinkoff.edu.domain.jdbc.repo.LinkChatRepo;
import ru.tinkoff.edu.service.LinkChatService;

import java.util.List;
@Service
@AllArgsConstructor
public class JdbcLinkChatService implements LinkChatService {
    private final LinkChatRepo linkChatRepo;


    @Override
    public void add(LinkChat linkChat) throws InvalidInputDataException {
        linkChatRepo.add(linkChat);
    }

    @Override
    public void remove(LinkChat linkChat) {
        linkChatRepo.untrack(linkChat.getChatId(), linkChat.getLinkId());
    }

    @Override
    public List<LinkChat> findAll() {
        return linkChatRepo.findAll();
    }

    @Override
    public List<Link> getLinksByChatId(long chatId) {
        return linkChatRepo.getLinksByChatId(chatId);
    }

    @Override
    public List<Chat> getChatsByLink(long linkId) {
        return linkChatRepo.getChatsByLinkId(linkId);
    }

}

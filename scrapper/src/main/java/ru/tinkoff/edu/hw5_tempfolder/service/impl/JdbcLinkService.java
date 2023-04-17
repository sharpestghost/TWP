package ru.tinkoff.edu.hw5_tempfolder.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.tinkoff.edu.exception.InvalidInputDataException;
import ru.tinkoff.edu.hw5_tempfolder.entity.Link;
import ru.tinkoff.edu.hw5_tempfolder.repo.impl.ChatImpl;
import ru.tinkoff.edu.hw5_tempfolder.service.LinkService;

import java.net.URI;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class JdbcLinkService implements LinkService {
    private final ChatImpl chatimpl;

    @Override
    public Link add(long tgChatId) throws InvalidInputDataException {
        //??
        return null;
    }

    @Override
    public Link remove(long tgChatId, URI url) {
        //??
        return null;
    }

    @Override
    public List<Link> listAll(long tgChatId) {
        return chatimpl.findAllLinks(tgChatId);
    }
}

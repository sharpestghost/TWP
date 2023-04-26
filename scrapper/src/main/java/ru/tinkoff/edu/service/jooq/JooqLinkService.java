package ru.tinkoff.edu.service.jooq;

import ru.tinkoff.edu.exception.InvalidInputDataException;
import ru.tinkoff.edu.hw5_tempfolder.entity.Link;
import ru.tinkoff.edu.service.LinkService;

import java.net.URI;
import java.util.List;

public class JooqLinkService extends LinkService {
    //TODO
    @Override
    public Link add(Long tgChatId, URI url) throws InvalidInputDataException {
        return null;
    }

    @Override
    public Link remove(Long tgChatId, URI url) {
        return null;
    }

    @Override
    public List<Link> listAll(Long tgChatId) {
        return null;
    }

    @Override
    public List<Link> listAll() {
        return null;
    }

    @Override
    public void updateLinkData(Link link) {

    }

    @Override
    public List<Link> getLinksForUpdate() {
        return null;
    }
}

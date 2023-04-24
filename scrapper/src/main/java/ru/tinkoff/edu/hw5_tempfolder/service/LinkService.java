package ru.tinkoff.edu.hw5_tempfolder.service;

import ru.tinkoff.edu.exception.InvalidInputDataException;
import ru.tinkoff.edu.hw5_tempfolder.entity.Chat;
import ru.tinkoff.edu.hw5_tempfolder.entity.Link;

import java.net.URI;
import java.util.List;

public interface LinkService {
    Link add(Long tgChatId, URI url);
    Link remove(Long tgChatId, URI url);
    List<Link> listAll(Long tgChatId);
    List<Link> listAll();
    List<Link> findLinksForUpdate();
    void updateLinkData(Link link);
}


package ru.tinkoff.edu.hw5_tempfolder.service;

import ru.tinkoff.edu.exception.InvalidInputDataException;
import ru.tinkoff.edu.hw5_tempfolder.entity.Link;

import java.net.URI;
import java.util.List;

public interface LinkService {
    Link add(long tgChatId) throws InvalidInputDataException;
    Link remove(long tgChatId, URI url);
    List<Link> listAll();
    List<Link> listAllByChatId(long tgChatId);
}


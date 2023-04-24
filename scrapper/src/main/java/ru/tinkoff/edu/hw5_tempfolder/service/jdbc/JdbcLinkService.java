package ru.tinkoff.edu.hw5_tempfolder.service.jdbc;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.tinkoff.edu.hw5_tempfolder.entity.Chat;
import ru.tinkoff.edu.hw5_tempfolder.entity.Link;
import ru.tinkoff.edu.hw5_tempfolder.entity.LinkChat;
import ru.tinkoff.edu.hw5_tempfolder.repo.ChatRepo;
import ru.tinkoff.edu.hw5_tempfolder.repo.LinkRepo;
import ru.tinkoff.edu.hw5_tempfolder.service.LinkService;

import java.net.URI;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class JdbcLinkService implements LinkService {
    private final LinkChat linkChat;
    private final LinkRepo linkRepo;
    private final ChatRepo chatRepo;

    @Override
    public Link add(Long chatId, URI url) {
       //add implementation here
        return new Link();
    }

    @Override
    public Link remove(Long chatId, URI url) {
        return null;
    }

    @Override
    public List<Link> listAll(Long chatId) {
        return chatRepo.findAllLinks(chatId);
    }

    @Override
    public List<Link> listAll() {
        return linkRepo.findAll();
    }

    @Override
    public List<Link> findLinksForUpdate() {
        //task 1.5
        return null;
    }


    @Override
    public void updateLinkData(Link link) {
        linkRepo.updateLinkData(link.getId());
    }
}
package ru.tinkoff.edu.hw5_tempfolder.service.jdbc;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.tinkoff.edu.converter.EntityConverter;
import ru.tinkoff.edu.exception.InvalidInputDataException;
import ru.tinkoff.edu.hw5_tempfolder.entity.Link;
import ru.tinkoff.edu.hw5_tempfolder.entity.LinkChat;
import ru.tinkoff.edu.hw5_tempfolder.repo.ChatRepo;
import ru.tinkoff.edu.hw5_tempfolder.repo.LinkRepo;
import ru.tinkoff.edu.hw5_tempfolder.service.LinkService;

import java.net.URI;
import java.util.List;

@Service
@AllArgsConstructor
public class JdbcLinkService implements LinkService {
    private final LinkRepo linkRepo;
    private final ChatRepo chatRepo;

    @Override
    public Link add(Long chatId, URI url) throws InvalidInputDataException {
       Link link = EntityConverter.createLink(url.toString());
       linkRepo.add(link);
       return link;
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
    public List<Link> getLinksForUpdate() {
        return linkRepo.getOldLinksListForUpdate();
    }


    @Override
    public void updateLinkData(Link link) {
        linkRepo.updateLinkData(link.getId());
    }
}
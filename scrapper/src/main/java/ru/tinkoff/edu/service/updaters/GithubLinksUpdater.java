package ru.tinkoff.edu.service.updaters;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.tinkoff.edu.GithubRepo;
import ru.tinkoff.edu.ParsedObject;
import ru.tinkoff.edu.converter.EntityConverter;
import ru.tinkoff.edu.dto.response.RepoResponse;
import ru.tinkoff.edu.hw5_tempfolder.entity.Link;
import ru.tinkoff.edu.service.LinkService;
import ru.tinkoff.edu.service.LinkUpdater;

import java.time.OffsetDateTime;

@AllArgsConstructor
@Service
public class GithubLinksUpdater implements LinkUpdater {
    private final LinkService linkService;
    private final BotUpdater botUpdater;

    @Override
    public void update(ParsedObject repo, Link link) {
        RepoResponse response = EntityConverter.getResponse((GithubRepo) repo);
        link.setLastUpdateDate(OffsetDateTime.now());
        if (response.lastUpdateDate().isBefore(link.getLastUpdateDate())) {
            link.setLastUpdateDate(response.lastUpdateDate());
            botUpdater.postUpdate(link);
        }
        linkService.updateLinkData(link);
    }
}
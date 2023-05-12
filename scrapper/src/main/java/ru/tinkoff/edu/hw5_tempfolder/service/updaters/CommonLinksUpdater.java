package ru.tinkoff.edu.hw5_tempfolder.service.updaters;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.tinkoff.edu.GithubRepo;
import ru.tinkoff.edu.ParsedObject;
import ru.tinkoff.edu.StackOverflowQuestion;
import ru.tinkoff.edu.hw5_tempfolder.entity.Chat;
import ru.tinkoff.edu.hw5_tempfolder.entity.Link;
import ru.tinkoff.edu.hw5_tempfolder.repo.LinkRepo;
import ru.tinkoff.edu.hw5_tempfolder.service.LinkService;
import ru.tinkoff.edu.hw5_tempfolder.service.LinkUpdater;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.List;

@AllArgsConstructor
@Service
public class CommonLinksUpdater implements LinkUpdater {
    private final GithubLinksUpdater githubLinksUpdater;
    private final StackOverflowLinksUpdater stackOverflowLinksUpdater;


    @Override
    public void update(ParsedObject object, Link link) {
        if (object instanceof GithubRepo repo) {
            githubLinksUpdater.update(repo, link);
        } else if (object instanceof StackOverflowQuestion question) {
            stackOverflowLinksUpdater.update(question, link);
        }
    }
}

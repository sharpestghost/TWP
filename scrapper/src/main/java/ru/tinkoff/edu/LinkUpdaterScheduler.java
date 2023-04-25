package ru.tinkoff.edu;


import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.tinkoff.edu.hw5_tempfolder.entity.Link;
import ru.tinkoff.edu.hw5_tempfolder.service.LinkService;
import ru.tinkoff.edu.hw5_tempfolder.service.LinkUpdater;
import ru.tinkoff.edu.hw5_tempfolder.service.updaters.GithubLinksUpdater;
import ru.tinkoff.edu.hw5_tempfolder.service.updaters.StackOverflowLinksUpdater;

import java.util.List;

@Component
@RequiredArgsConstructor
public class LinkUpdaterScheduler {

    private final LinkService linkService;
    private final GithubLinksUpdater githubLinksUpdater;
    private final StackOverflowLinksUpdater stackLinksUpdater;
    @Scheduled(fixedDelayString = "#{delay(interval)}")
    public void update() {
        List<Link> links = linkService.findLinksForUpdate();
        for (Link link: links) {
            ParsedObject object = LinkParser.parseLink(link.toString());
            if (object instanceof GithubRepo repo) {
                githubLinksUpdater.update(repo, link);
            } else if (object instanceof StackOverflowQuestion question) {
                stackLinksUpdater.update(question, link);
            }
        }
    }
}
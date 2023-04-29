package ru.tinkoff.edu;


import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.tinkoff.edu.entity.Link;
import ru.tinkoff.edu.service.LinkService;
import ru.tinkoff.edu.service.updaters.GithubLinksUpdater;
import ru.tinkoff.edu.service.updaters.StackOverflowLinksUpdater;

import java.util.List;

@Component
@RequiredArgsConstructor
public class LinkUpdaterScheduler {

    private final LinkService linkService;
    private final GithubLinksUpdater githubLinksUpdater;
    private final StackOverflowLinksUpdater stackLinksUpdater;
    @Scheduled(fixedDelayString = "#{delay(interval)}")
    public void update() {
        List<Link> links = linkService.getLinksForUpdate();
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
package ru.tinkoff.edu;


import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.tinkoff.edu.hw5_tempfolder.entity.Link;
import ru.tinkoff.edu.hw5_tempfolder.service.LinkService;
import ru.tinkoff.edu.hw5_tempfolder.service.LinkUpdater;

import java.util.List;

@Component
@RequiredArgsConstructor
public class LinkUpdaterScheduler {

    private final LinkUpdater linkUpdater;
    private final LinkService linkService;
    @Scheduled(fixedDelayString = "#{delay(interval)}")
    public void update() {
        System.out.println("Update links...");
        List<Link> links = linkService.listAll();
        for (Link link: links) {
            //TODO: update links
        }
    }
}
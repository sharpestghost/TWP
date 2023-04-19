package ru.tinkoff.edu.hw5_tempfolder.service.updaters;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.tinkoff.edu.hw5_tempfolder.service.LinkService;
import ru.tinkoff.edu.hw5_tempfolder.service.LinkUpdater;

@AllArgsConstructor
@Service
public class StackOverflowLinksUpdater implements LinkUpdater {
    private final LinkService linkService;
    @Override
    public void update(String link) {

    }
}

package ru.tinkoff.edu.hw5_tempfolder.service.updaters;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.tinkoff.edu.GithubRepo;
import ru.tinkoff.edu.ParsedObject;
import ru.tinkoff.edu.StackOverflowQuestion;
import ru.tinkoff.edu.client.StackOverflowClient;
import ru.tinkoff.edu.converter.EntityConverter;
import ru.tinkoff.edu.dto.response.QuestionResponse;
import ru.tinkoff.edu.dto.response.RepoResponse;
import ru.tinkoff.edu.hw5_tempfolder.entity.Link;
import ru.tinkoff.edu.hw5_tempfolder.repo.LinkRepo;
import ru.tinkoff.edu.hw5_tempfolder.service.LinkService;
import ru.tinkoff.edu.hw5_tempfolder.service.LinkUpdater;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.Stack;

@AllArgsConstructor
@Service
public class StackOverflowLinksUpdater implements LinkUpdater {
    private final LinkService linkService;
    private final BotUpdater botUpdater;


    @Override
    public void update(ParsedObject question, Link link) {
        QuestionResponse response = EntityConverter.getQuestion((StackOverflowQuestion) question);
        link.setLastUpdateDate(OffsetDateTime.now());
        if (response.answer_count() > link.getAnswerCount()) {
            link.setAnswerCount(response.answer_count());
            botUpdater.postUpdate(link);
        }
        if (response.last_edit_date().isBefore(link.getLastUpdateDate())) {
            link.setLastUpdateDate(response.last_edit_date());
            botUpdater.postUpdate(link);
        }
        linkService.updateLinkData(link);
    }
}

package ru.tinkoff.edu.service.updaters;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.tinkoff.edu.GithubRepo;
import ru.tinkoff.edu.ParsedObject;
import ru.tinkoff.edu.StackOverflowQuestion;
import ru.tinkoff.edu.converter.EntityConverter;
import ru.tinkoff.edu.dto.response.QuestionResponse;
import ru.tinkoff.edu.dto.response.RepoResponse;
import ru.tinkoff.edu.entity.Link;
import ru.tinkoff.edu.service.LinkService;
import ru.tinkoff.edu.service.LinkUpdater;

import java.time.OffsetDateTime;

@AllArgsConstructor
@Service
public class CommonLinksUpdater implements LinkUpdater {
  //  private final GithubLinksUpdater githubLinksUpdater;
  //  private final StackOverflowLinksUpdater stackOverflowLinksUpdater;
    private final LinkService linkService;
    private final BotUpdater botUpdater;

    @Override
    public void update(ParsedObject object, Link link) {
        if (object instanceof GithubRepo repo) {
            RepoResponse response = EntityConverter.getResponse(repo);
            link.setLastUpdateDate(OffsetDateTime.now());
            if (response.lastUpdateDate().isBefore(link.getLastUpdateDate())) {
                link.setLastUpdateDate(response.lastUpdateDate());
                botUpdater.postUpdate(link);
            }
            linkService.updateLinkData(link);
        } else if (object instanceof StackOverflowQuestion question) {
            QuestionResponse response = EntityConverter.getQuestion(question);
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
}

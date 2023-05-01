package ru.tinkoff.edu.service.updaters;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.tinkoff.edu.ParsedObject;
import ru.tinkoff.edu.StackOverflowQuestion;
import ru.tinkoff.edu.converter.EntityConverter;
import ru.tinkoff.edu.dto.response.QuestionResponse;
import ru.tinkoff.edu.entity.Link;
import ru.tinkoff.edu.service.LinkService;
import ru.tinkoff.edu.service.LinkUpdater;

import java.time.OffsetDateTime;

@AllArgsConstructor
@Service
public class StackOverflowLinksUpdater implements LinkUpdater{
    private final LinkService linkService;
    private final BotUpdater botUpdater;


    @Override
    public void update(ParsedObject question, Link link) {
        QuestionResponse response = EntityConverter.getQuestion((StackOverflowQuestion) question);
        System.out.println("link data: "+ link);
        if (link.getAnswerCount() == null || response.answer_count() > link.getAnswerCount()) {
            System.out.println(response.answer_count());
            link.setAnswerCount(response.answer_count());
            botUpdater.postUpdate(link);
        }
        if (response.last_activity_date().isBefore(link.getLastUpdateDate())) {
            link.setLastUpdateDate(response.last_activity_date());
            botUpdater.postUpdate(link);
        }
        linkService.updateLinkData(link);
    }


}

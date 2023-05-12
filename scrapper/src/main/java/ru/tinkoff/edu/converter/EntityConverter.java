package ru.tinkoff.edu.converter;

import ru.tinkoff.edu.*;
import ru.tinkoff.edu.client.GithubClient;
import ru.tinkoff.edu.client.StackOverflowClient;
import ru.tinkoff.edu.dto.response.QuestionResponse;
import ru.tinkoff.edu.dto.response.RepoResponse;
import ru.tinkoff.edu.exception.InvalidInputDataException;
import ru.tinkoff.edu.hw5_tempfolder.entity.Link;

public class EntityConverter {
    private static final GithubClient githubClient = new GithubClient();
    private static final StackOverflowClient stackOverflowClient = new StackOverflowClient();

    public static Link createLink(String url) throws InvalidInputDataException {
        ParsedObject object = LinkParser.parseLink(url);
        if (object == null) {
            throw new InvalidInputDataException();
        }
        Link link = new Link();
        link.setURL(url);
        if (object instanceof GithubRepo repo) {
            RepoResponse response = getResponse(repo);
            link.setLastUpdateDate(response.lastUpdateDate());
        } else {
            if (object instanceof StackOverflowQuestion question) {
                QuestionResponse response = getQuestion(question);
                link.setLastUpdateDate(response.last_edit_date());
                link.setAnswerCount(response.answer_count());
            }
        }
        return link;
    }

    public static RepoResponse getResponse(GithubRepo repo) {
        return githubClient.getRepo(repo.user(), repo.repo());
    }

    public static QuestionResponse getQuestion(StackOverflowQuestion question) {
        return stackOverflowClient.getQuestion(question.id());
    }
}

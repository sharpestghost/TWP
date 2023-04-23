package ru.tinkoff.edu.hw5_tempfolder.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.tinkoff.edu.GithubRepo;
import ru.tinkoff.edu.LinkParser;
import ru.tinkoff.edu.ParsedObject;
import ru.tinkoff.edu.StackOverflowQuestion;
import ru.tinkoff.edu.exception.InvalidInputDataException;
import ru.tinkoff.edu.hw5_tempfolder.entity.Link;
import ru.tinkoff.edu.hw5_tempfolder.entity.LinkChat;
import ru.tinkoff.edu.hw5_tempfolder.repo.impl.ChatImpl;
import ru.tinkoff.edu.hw5_tempfolder.repo.impl.LinkChatImpl;
import ru.tinkoff.edu.hw5_tempfolder.repo.impl.LinkImpl;
import ru.tinkoff.edu.hw5_tempfolder.service.LinkService;

import java.net.URI;
import java.util.List;
import java.util.logging.Logger;

@Repository
@RequiredArgsConstructor
public class JdbcLinkService implements LinkService {
    private final ChatImpl chatImpl;
    private final LinkImpl linkImpl;
    private final LinkChatImpl linkChatImpl;
    static final Logger LOGGER =  Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    @Override
    public Link add(String url, String linkname, String description) throws InvalidInputDataException {
        Link link = new Link();
        ParsedObject linkObject = LinkParser.parseLink(url);
        if (!(linkObject instanceof StackOverflowQuestion) && !(linkObject instanceof GithubRepo)) {
           //add an exception here?
            return null;
        }
        link.setURL(url);
        link.setLinkName(linkname);
        link.setDescription(description);
        return link;
    }

    @Override
    public Link remove(URI url) {
        Link link = linkImpl.getByLink(url.toString());
        return link;
    }

    public LinkChat track(long tgChatId, long linkId) {
        LinkChat linkChat = new LinkChat(tgChatId, linkId);
        //linkChatImpl.add(linkChat);
        return null;
    }

    @Override
    public void update(Link link) {

    }

    @Override
    public List<Link> listAll() {
        return null;
    }
    @Override
    public List<Link> listAllByChatId(long tgChatId) {
        return chatImpl.findAllLinks(tgChatId);
    }

    private Link createLink() {
        return null;
    }
}

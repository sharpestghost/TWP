package ru.tinkoff.edu.service.jooq;

import lombok.AllArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tinkoff.edu.domain.jooq.Tables;
import ru.tinkoff.edu.exception.DataNotFoundException;
import ru.tinkoff.edu.exception.InvalidInputDataException;
import ru.tinkoff.edu.hw5_tempfolder.entity.Chat;
import ru.tinkoff.edu.hw5_tempfolder.entity.Link;
import ru.tinkoff.edu.hw5_tempfolder.entity.LinkChat;
import ru.tinkoff.edu.service.ChatService;
import ru.tinkoff.edu.service.LinkChatService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class JooqLinkChatService implements LinkChatService {
    private DSLContext context;
    private static final String INSERT_LINKCHAT_ALREADYEXISTS = "This link is already tracking.";
    private static final String REMOVE_LINKCHAT_NOTFOUND = "Tracked link not found.";

    @Transactional
    @Override
    public void add(LinkChat linkChat) throws InvalidInputDataException {
        if (linkChat == null) {
            throw new InvalidInputDataException();
        }
        int cnt = context.selectCount()
                .from(Tables.LINK_CHAT)
                .where(Tables.LINK_CHAT.CHAT_ID.eq(linkChat.getChatId().intValue()))
                .and(Tables.LINK_CHAT.LINK_ID.eq(linkChat.getLinkId().intValue()))
                .execute();
        if (cnt > 0) {
            throw new DataNotFoundException(INSERT_LINKCHAT_ALREADYEXISTS);
        } else {
            context.insertInto(Tables.LINK_CHAT, Tables.LINK_CHAT.fields()).values(linkChat.getChatId(), linkChat.getLinkId())
                    .execute();
        }
    }

    @Transactional
    @Override
    public void remove(LinkChat linkChat) {
        if (linkChat == null) {
            throw new InvalidInputDataException();
        }
        int cnt = context.deleteFrom(Tables.LINK_CHAT)
                .where(Tables.LINK_CHAT.CHAT_ID.eq(linkChat.getChatId().intValue()))
                .and(Tables.LINK_CHAT.LINK_ID.eq(linkChat.getLinkId().intValue()))
                .execute();
        if (cnt == 0) {
            throw new DataNotFoundException(REMOVE_LINKCHAT_NOTFOUND);
        }
    }

    @Override
    public List<LinkChat> findAll() {
        return context.select(Tables.LINK_CHAT.fields())
                .from(Tables.LINK_CHAT)
                .fetchInto(LinkChat.class);
    }

    @Override
    public List<Link> getLinksByChatId(long chatId) {
        //duplicate method from chatservice, fix it from one of next commits
        Set<Integer> linkIds = new HashSet<>(context.select(Tables.LINK_CHAT.LINK_ID)
                .from(Tables.LINK)
                .where(Tables.LINK_CHAT.CHAT_ID.eq((int) chatId))
                .fetchInto(Integer.class));
        return context.select(Tables.LINK.fields())
                .from(Tables.LINK)
                .where(Tables.LINK.ID.in(linkIds))
                .fetchInto(Link.class);
    }

    @Override
    public List<Chat> getChatsByLink(long linkId) {
        //duplicate method from linkservice, fix it from one of next commits
        Set<Integer> chatIds = new HashSet<>(context.select(Tables.LINK_CHAT.CHAT_ID)
                .from(Tables.LINK)
                .where(Tables.LINK_CHAT.LINK_ID.eq((int) linkId))
                .fetchInto(Integer.class));
        return context.select(Tables.CHAT.fields())
                .from(Tables.CHAT)
                .where(Tables.CHAT.ID.in(chatIds))
                .fetchInto(Chat.class);
    }
}

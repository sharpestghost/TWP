package ru.tinkoff.edu.controller;

import org.springframework.web.bind.annotation.*;
import ru.tinkoff.edu.dto.request.AddLinkRequest;
import ru.tinkoff.edu.dto.request.RemoveLinkRequest;
import ru.tinkoff.edu.dto.response.LinkResponse;
import ru.tinkoff.edu.dto.response.ListLinksResponse;

@RestController
@RequestMapping(name = "/links")
public class LinksController {

    public ListLinksResponse getLinks(@RequestHeader("Tg-Chat-Id") long tgChatId) {
        return new ListLinksResponse(null, 0);
    }

    public LinkResponse addLink(@RequestHeader("Tg-Chat-Id") long tgChatId, @RequestBody AddLinkRequest addLinkRequest) {
        return new LinkResponse(tgChatId, addLinkRequest.link());
    }

    public LinkResponse removeLink(@RequestHeader("Tg-Chat-Id") long tgChatId, @RequestBody RemoveLinkRequest removeLinkRequest) {
        return new LinkResponse(tgChatId, removeLinkRequest.link());
    }
}

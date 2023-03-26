package ru.tinkoff.edu.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.tinkoff.edu.dto.request.AddLinkRequest;
import ru.tinkoff.edu.dto.request.RemoveLinkRequest;
import ru.tinkoff.edu.dto.response.LinkResponse;
import ru.tinkoff.edu.dto.response.ListLinksResponse;

import java.util.List;

@RestController
@RequestMapping(name = "/links")
public class LinksController {

    public ListLinksResponse getLinks(long tgChatId) {
        return new ListLinksResponse(null, 0);
    }

    public LinkResponse addLink(@RequestParam long tgChatId, @RequestBody AddLinkRequest addLinkRequest) {
        return new LinkResponse(tgChatId, addLinkRequest.link());
    }

    public LinkResponse removeLink(@RequestParam long tgChatId, @RequestBody RemoveLinkRequest removeLinkRequest) {
        return new LinkResponse(tgChatId, removeLinkRequest.link());
    }
}

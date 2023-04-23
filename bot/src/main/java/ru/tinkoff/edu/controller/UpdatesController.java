package ru.tinkoff.edu.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.tinkoff.edu.scrapperlink.dto.request.LinkUpdate;

@RestController
@RequestMapping("/updates")
public class UpdatesController {

    public void update(@RequestBody LinkUpdate linkUpdate) {
        System.out.println("check");
    }
}

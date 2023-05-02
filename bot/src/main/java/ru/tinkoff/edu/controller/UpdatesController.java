package ru.tinkoff.edu.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.tinkoff.edu.dto.LinkUpdate;

@RestController
@RequestMapping("/updates")
public class UpdatesController {

    public void update(@RequestBody LinkUpdate linkUpdate) {
        //send update, error handling if occurs
    }
}

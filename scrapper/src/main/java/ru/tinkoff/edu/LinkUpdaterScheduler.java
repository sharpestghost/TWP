package ru.tinkoff.edu;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component

public class LinkUpdaterScheduler {

    @Scheduled(fixedDelayString = "#{delay(interval)}")
    public void update() {
        //метод для обновления данных из бд
    }
}
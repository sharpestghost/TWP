package ru.tinkoff.edu.bot.metrics;

import io.micrometer.core.instrument.Metrics;

public class MetricsInspector {
    private static final String COMPLETED_MESSAGES = "messages_sent";

    private MetricsInspector() {
    }

    public static void incrementCounter() {
        System.out.println("smth happende");
        Metrics.counter(COMPLETED_MESSAGES).increment();
    }
}

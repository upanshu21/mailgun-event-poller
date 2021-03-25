package com.upanshu.mailgun.scheduler;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.upanshu.mailgun.poller.EventPoller;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EventPollerScheduler {

    private static final Logger log = LoggerFactory.getLogger(EventPollerScheduler.class);

    private final EventPoller eventPoller;

    public EventPollerScheduler(EventPoller eventPoller) {
        this.eventPoller = eventPoller;
    }

    @Scheduled(fixedRate = 10000)
    public void getEventPagesAsJson() throws UnirestException {
        JSONObject event = eventPoller.getEventsFromMailgun();
        log.info("received event {}", event);

        //TO DO: Polling logic
    }
}

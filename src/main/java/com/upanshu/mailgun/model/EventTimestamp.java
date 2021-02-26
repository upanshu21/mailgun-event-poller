package com.upanshu.mailgun.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class EventTimestamp {

    private final String timestamp;

    public EventTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getTimestamp() {
        return timestamp;
    }

}

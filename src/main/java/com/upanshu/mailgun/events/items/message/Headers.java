package com.upanshu.mailgun.events.items.message;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Headers {

    private final String subject;
    private final String messageId;
    private final String from;
    private final String to;

    public Headers(@JsonProperty("subject") String subject,
                   @JsonProperty("message-id") String messageId,
                   @JsonProperty("from") String from,
                   @JsonProperty("to") String to) {
        this.subject = subject;
        this.messageId = messageId;
        this.from = from;
        this.to = to;
    }

}

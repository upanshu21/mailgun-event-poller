package com.upanshu.mailgun.events.items.message;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Message {

    private final Headers headers;
    private final List<String> attachments;
    private final List<String> recipients;
    private final Integer size;

    public Message(@JsonProperty("headers") Headers headers,
                   @JsonProperty("attachments") List<String> attachments,
                   @JsonProperty("recipients") List<String> recipients,
                   @JsonProperty("size") Integer size) {
        this.headers = headers;
        this.attachments = attachments;
        this.recipients = recipients;
        this.size = size;
    }

    public Headers getHeaders() {
        return headers;
    }

    public List<String> getAttachments() {
        return attachments;
    }

    public List<String> getRecipients() {
        return recipients;
    }

    public Integer getSize() {
        return  size;
    }

}

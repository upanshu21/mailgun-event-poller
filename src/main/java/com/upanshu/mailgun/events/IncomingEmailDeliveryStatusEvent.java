package com.upanshu.mailgun.events;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.upanshu.mailgun.events.items.MailgunRawTrackingEvent;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IncomingEmailDeliveryStatusEvent {

    private final Paging paging;
    private final List<MailgunRawTrackingEvent> items;

    public IncomingEmailDeliveryStatusEvent(@JsonProperty("paging") Paging paging,
                                            @JsonProperty("items") List<MailgunRawTrackingEvent> items) {
        this.paging = paging;
        this.items = items;
    }

    public Paging getPaging() {
        return paging;
    }

    public List<MailgunRawTrackingEvent> getItems() {
        return items;
    }

}

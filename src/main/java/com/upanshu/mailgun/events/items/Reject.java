package com.upanshu.mailgun.events.items;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Reject {

    private final String reason;
    private final String description;

    public Reject(@JsonProperty("reason") String reason,
                  @JsonProperty("description") String description) {
        this.reason = reason;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getReason() {
        return reason;
    }
}

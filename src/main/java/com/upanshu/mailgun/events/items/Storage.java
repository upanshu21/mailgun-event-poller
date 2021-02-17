package com.upanshu.mailgun.events.items;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Storage {

    private final String url;
    private final String key;

    public Storage(@JsonProperty("url") String url,
                   @JsonProperty("key") String key) {
        this.url = url;
        this.key = key;
    }

    public String getUrl() {
        return url;
    }

    public String getKey() {
        return key;
    }
}



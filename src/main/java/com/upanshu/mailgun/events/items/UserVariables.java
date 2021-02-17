package com.upanshu.mailgun.events.items;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserVariables {

    @JsonIgnore
    private final Map<String, String> additionalProperties = new HashMap<String, String>();

    public Map<String, String> getAdditionalProperties() {
        return this.additionalProperties;
    }
}

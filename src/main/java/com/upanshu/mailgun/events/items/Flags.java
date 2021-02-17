package com.upanshu.mailgun.events.items;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Flags {

    private final boolean isSystemTest;
    private final boolean isRouted;
    private final boolean isAuthenticated;
    private final boolean isTestMode;

    public Flags(@JsonProperty("is-system-test") boolean isSystemTest,
                 @JsonProperty("is-routed") boolean isRouted,
                 @JsonProperty("is-authenticated") boolean isAuthenticated,
                 @JsonProperty("is-test-mode") boolean isTestMode) {
        this.isSystemTest = isSystemTest;
        this.isRouted = isRouted;
        this.isAuthenticated = isAuthenticated;
        this.isTestMode = isTestMode;
    }

    public boolean getIsSystemTest() {
        return isSystemTest;
    }

    public boolean getIsRouted() {
        return isRouted;
    }

    public boolean getIsAuthenticated() {
        return isAuthenticated;
    }

    public boolean getIsTestMode() {
        return isTestMode;
    }
}

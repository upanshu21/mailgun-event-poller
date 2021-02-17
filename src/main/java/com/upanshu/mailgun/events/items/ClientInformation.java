package com.upanshu.mailgun.events.items;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ClientInformation {

    private final String clientType;
    private final String clientOs;
    private final String deviceType;
    private final String clientName;
    private final String userAgent;

    public ClientInformation(
            @JsonProperty("client-type") String clientType,
            @JsonProperty("client-os") String clientOs,
            @JsonProperty("device-type") String deviceType,
            @JsonProperty("client-name") String clientName,
            @JsonProperty("user-agent") String userAgent) {
        this.clientType = clientType;
        this.clientOs = clientOs;
        this.deviceType = deviceType;
        this.clientName = clientName;
        this.userAgent = userAgent;
    }

    public String getClientType() {
        return clientType;
    }

    public String getClientOs() {
        return clientOs;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public String getClientName() {
        return clientName;
    }

    public String getUserAgent() {
        return userAgent;
    }
}

package com.upanshu.mailgun.events.items;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Envelope {

    private final String senderIp;
    private final String sender;
    private final String transport;
    private final String targets;

    public Envelope(@JsonProperty("sending-ip") String senderIp,
                    @JsonProperty("sender") String sender,
                    @JsonProperty("transport") String transport,
                    @JsonProperty("targets") String targets) {
        this.senderIp = senderIp;
        this.sender = sender;
        this.transport = transport;
        this.targets = targets;
    }

    public String getSenderIp() {
        return senderIp;
    }

    public String getSender(){
        return sender;
    }

    public String getTransport() {
        return transport;
    }

    public String getTargets() {
        return targets;
    }
}

package com.upanshu.mailgun.events.items;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.upanshu.mailgun.events.items.message.Message;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MailgunRawTrackingEvent {

    private final String method;
    private final Flags flags;
    private final Storage storage;
    private final Message message;
    private final List<Tags> tags;
    private final UserVariables userVariables;
    private final Envelope envelope;
    private final List<String> campaigns;
    private final String logLevel;
    private final Reject reject;
    private final String recipient;
    private final String id;
    private final String recipientDomain;
    private final String event;
    private final double timestamp;
    private final DeliveryStatus deliveryStatus;
    private final String severity;
    private final GeoLocation geoLocation;
    private final String ip;
    private final ClientInformation clientInformation;

    public MailgunRawTrackingEvent(@JsonProperty("items") String method,
                                   @JsonProperty("flags") Flags flags,
                                   @JsonProperty("storage") Storage storage,
                                   @JsonProperty("message") Message message,
                                   @JsonProperty("tags") List<Tags> tags,
                                   @JsonProperty("user-variables") UserVariables userVariables,
                                   @JsonProperty("envelope") Envelope envelope,
                                   @JsonProperty("campaigns") List<String> campaigns,
                                   @JsonProperty("log-level") String logLevel,
                                   @JsonProperty("reject") Reject reject,
                                   @JsonProperty("recipient") String recipient,
                                   @JsonProperty("id") String id,
                                   @JsonProperty("recipient-domain") String recipientDomain,
                                   @JsonProperty("event") String event,
                                   @JsonProperty("timestamp") double timestamp,
                                   @JsonProperty("delivery-status") DeliveryStatus deliveryStatus,
                                   @JsonProperty("severity") String severity,
                                   @JsonProperty("geolocation") GeoLocation geoLocation,
                                   @JsonProperty("ip") String ip,
                                   @JsonProperty("client-info") ClientInformation clientInformation){
        this.method = method;
        this.flags = flags;
        this.storage = storage;
        this.message = message;
        this.tags = tags;
        this.userVariables = userVariables;
        this.envelope = envelope;
        this.campaigns = campaigns;
        this.logLevel = logLevel;
        this.reject = reject;
        this.recipient = recipient;
        this.id = id;
        this.recipientDomain = recipientDomain;
        this.event = event;
        this.timestamp = timestamp;
        this.deliveryStatus = deliveryStatus;
        this.severity = severity;
        this.geoLocation = geoLocation;
        this.ip = ip;
        this.clientInformation = clientInformation;
    }

    public String getMethod() {
        return method;
    }

    public Flags getFlags() {
        return flags;
    }

    public Storage getStorage() {
        return storage;
    }

    public Message getMessage() {
        return message;
    }

    public List<Tags> getTags() {
        return tags;
    }

    public UserVariables getUserVariables() {
        return userVariables;
    }

    public Envelope getEnvelope() {
        return envelope;
    }

    public List<String> getCampaigns() {
        return campaigns;
    }

    public String getLogLevel() {
        return logLevel;
    }

    public Reject getReject() {
        return  reject;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getId() {
        return id;
    }

    public String getRecipientDomain() {
        return recipientDomain;
    }

    public String getEvent() {
        return event;
    }

    public double getTimestamp() {
        return timestamp;
    }

    public DeliveryStatus getDeliveryStatus() {
        return deliveryStatus;
    }

    public String getSeverity() {
        return severity;
    }

    public GeoLocation geoLocation() {
        return geoLocation;
    }

    public String getIp() {
        return ip;
    }

    public ClientInformation getClientInformation() {
        return clientInformation;
    }
}

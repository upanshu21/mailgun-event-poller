package com.upanshu.mailgun.events.items;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DeliveryStatus {

    private final Integer attemptNumber;
    private final Integer code;
    private final boolean utf8;
    private final String description;
    private final boolean tls;
    private final String message;
    private final String mxHost;
    private final boolean certificateVerified;
    private final Integer sessionSeconds;
    private final Integer retrySeconds;

    public DeliveryStatus(@JsonProperty("attempt-no") Integer attemptNumber,
                          @JsonProperty("code") Integer code,
                          @JsonProperty("utf8") boolean utf8,
                          @JsonProperty("description") String description,
                          @JsonProperty("tls") boolean tls,
                          @JsonProperty("message") String message,
                          @JsonProperty("mx-host") String mxHost,
                          @JsonProperty("certificate-verified") boolean certificateVerified,
                          @JsonProperty("session-seconds") Integer sessionSeconds,
                          @JsonProperty("retry-seconds") Integer retrySeconds) {
        this.attemptNumber = attemptNumber;
        this.code = code;
        this.utf8 = utf8;
        this.description = description;
        this.tls = tls;
        this.message = message;
        this.mxHost = mxHost;
        this.certificateVerified = certificateVerified;
        this.sessionSeconds = sessionSeconds;
        this.retrySeconds = retrySeconds;
    }

    public Integer getAttemptNumber() {
        return attemptNumber;
    }

    public Integer getCode() {
        return code;
    }

    public boolean getUtf8() {
        return utf8;
    }

    public String getDescription() {
        return description;
    }

    public boolean getTls() {
        return tls;
    }

    public String getMessage() {
        return message;
    }

    public String getMxHost() {
        return mxHost;
    }

    public boolean getCertificateVersion() {
        return certificateVerified;
    }

    public Integer getSessionSeconds() {
        return sessionSeconds;
    }

    public Integer getRetrySeconds() {
        return retrySeconds;
    }

}

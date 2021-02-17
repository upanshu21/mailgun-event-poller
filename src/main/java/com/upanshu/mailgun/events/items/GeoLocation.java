package com.upanshu.mailgun.events.items;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GeoLocation {

    private final String country;
    private final String region;
    private final String city;

    public GeoLocation(@JsonProperty("country") String country,
                       @JsonProperty("region") String region,
                       @JsonProperty("city") String city) {
        this.country = country;
        this.region = region;
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public String getRegion() {
        return region;
    }

    public String getCity() {
        return city;
    }
}

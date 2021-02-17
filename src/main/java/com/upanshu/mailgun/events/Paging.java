package com.upanshu.mailgun.events;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Paging {

    private final String next;
    private final String previous;
    private final String last;
    private final String first;

    public Paging(@JsonProperty("next") String next,
                  @JsonProperty("previous") String previous,
                  @JsonProperty("last") String last,
                  @JsonProperty("first") String first) {
        this.next = next;
        this.previous = previous;
        this.last = last;
        this.first = first;
    }

    public String getNext() {
        return next;
    }

    public String getPrevious() {
        return previous;
    }

    public String getLast() {
        return last;
    }

    public String getFirst() {
        return first;
    }

}

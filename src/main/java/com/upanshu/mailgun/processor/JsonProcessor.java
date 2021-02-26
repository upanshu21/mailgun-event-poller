package com.upanshu.mailgun.processor;

import com.upanshu.mailgun.utils.PollerConstants;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class JsonProcessor {

    private static final Logger log = LoggerFactory.getLogger(JsonProcessor.class);

    public BigDecimal getTimeStampForLastEvent(JSONObject event) {
        JSONArray arrayItems = event.getJSONArray("items");
        int length = arrayItems.length();
        if(length > 0) {
            JSONObject lastEvent = arrayItems.getJSONObject(length-1);
            return lastEvent.getBigDecimal("timestamp");
        } else {
            log.warn("No event received");
            return PollerConstants.THRESHOLD;
        }
    }

    public String getNextPageUrl(JSONObject event) {
        JSONObject eventPaging = event.getJSONObject("paging");
        return  eventPaging.getString("next");
    }

    public int isTrustworthy(BigDecimal timestamp, BigDecimal epocTime) {
        return timestamp.compareTo(epocTime);
    }

    public String getUrl(String defaultUrl, String updatedUrl) {
        if(updatedUrl == null) {
            return defaultUrl;
        } else {
            return updatedUrl;
        }
    }
}

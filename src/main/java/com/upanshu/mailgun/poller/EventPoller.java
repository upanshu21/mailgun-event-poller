package com.upanshu.mailgun.poller;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EventPoller {

    @Value("${mailgun.domain}")
    private String domain;
    @Value("${mailgun.api}")
    private String api;
    @Value("${mailgun.timeInEpocSeconds}")
    private String thresholdTimeStamp;
    @Value("${mailgun.NoOfEventsInSingleRequest}")
    private String limit;

    public JSONObject getEventsFromMailgun() throws UnirestException {

        HttpResponse<JsonNode> request = Unirest.get("https://api.mailgun.net/v3/" + domain + "/events")
                .basicAuth("api", api)
                .queryString("begin", thresholdTimeStamp)
                .queryString("ascending", "yes")
                .queryString("limit", limit)
                .asJson();
        return request.getBody().getObject();
    }
}

package com.upanshu.mailgun.poller;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

public class EventPoller {

    public JSONObject getLogs() throws UnirestException {

        String YOUR_DOMAIN_NAME = "sandboxd1382775df88420498e9237348912a78.mailgun.org";

        HttpResponse<JsonNode> request = Unirest.get("https://api.mailgun.net/v3/" + YOUR_DOMAIN_NAME + "/events")
                .basicAuth("api", "b26a53756fd0c37ba9878b579da0db4a-77751bfc-f0a44072")
                .queryString("begin", "Thurs, 30 Jan 2021 09:00:00 -0000")
                .queryString("ascending", "yes")
                .queryString("limit", 1)
                .asJson();
        return request.getBody().getObject();
    }
}

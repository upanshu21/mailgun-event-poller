package com.upanshu.mailgun.Repository;


import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class HttpClientImpl {

    public JSONObject getJsonData(String url, BigDecimal time) throws UnirestException {
        HttpResponse<JsonNode> request = Unirest.get(url)
                .basicAuth("api", "")
                .queryString("begin", time)
                .queryString("ascending", "yes")
                .queryString("limit", 1)
                .asJson();
        return request.getBody().getObject();
    }
}

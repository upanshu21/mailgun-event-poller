package com.upanshu.mailgun.mailer;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SendMail {

    @Value("${mailgun.domain}")
    private String domain;
    @Value("${mailgun.api}")
    private String api;

    public JsonNode sendEmailToMailgunMessage() throws UnirestException {
        String email = "";
        HttpResponse<JsonNode> request = Unirest.post("https://api.mailgun.net/v3/" + domain + "/messages")
                .basicAuth("api", api)
                .queryString("from", "Excited User <emailId>")
                .queryString("to", email)
                .queryString("subject", "Offer from team Ackerman")
                .queryString("text", "Will you join the levi squad? Also sent from code, testing.")
                .asJson();
        return request.getBody();
    }

}

package com.upanshu.mailgun.mailer;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Component;

@Component
public class SendMailImpl {

    public static JsonNode sendSimpleMessage(String domain) throws UnirestException {
        HttpResponse<JsonNode> request = Unirest.post("https://api.mailgun.net/v3/" + domain + "/messages")
                .basicAuth("api", "b26a53756fd0c37ba9878b579da0db4a-77751bfc-f0a44072")
                .queryString("from", "MailgunTest upanshu.chaudhary@knoldus.com")
                .queryString("to", "upanshu21@gmail.com")
                .queryString("subject", "Offer from team Ackerman")
                .queryString("text", "Will you join the levi squad? Also sent from code, testing.")
                .asJson();
        return request.getBody();
    }

}

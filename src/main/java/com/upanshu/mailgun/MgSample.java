//package com.upanshu.mailgun;
//
//import com.mashape.unirest.http.HttpResponse;
//import com.mashape.unirest.http.JsonNode;
//import com.mashape.unirest.http.Unirest;
//import com.mashape.unirest.http.exceptions.UnirestException;
//import org.springframework.stereotype.Component;
//
//@Component
//public class MgSample {
//
//    public static JsonNode sendSimpleMessage() throws UnirestException {
//        HttpResponse<JsonNode> request = Unirest.post("https://api.mailgun.net/v3/" + "sandboxd1382775df88420498e9237348912a78.mailgun.org" + "/messages")
//			    .basicAuth("api", "b26a53756fd0c37ba9878b579da0db4a-77751bfc-f0a44072")
//                .queryString("from", "Excited User <upanshu21@gmail.com>")
//                .queryString("to", "divyansh.stone@gmail.com")
//                .queryString("subject", "Offer from team Ackerman")
//                .queryString("text", "Will you join the levi squad? Also sent from code, testing.")
//                .asJson();
//        return request.getBody();
//    }
//}

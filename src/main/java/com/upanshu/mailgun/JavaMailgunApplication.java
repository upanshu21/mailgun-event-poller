package com.upanshu.mailgun;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.upanshu.mailgun.events.IncomingEmailDeliveryStatusEvent;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class JavaMailgunApplication {

	public static String YOUR_DOMAIN_NAME = "sandboxd1382775df88420498e9237348912a78.mailgun.org";



	public static JSONObject getLogs() throws UnirestException {

		HttpResponse<JsonNode> request = Unirest.get("https://api.mailgun.net/v3/" + YOUR_DOMAIN_NAME + "/events")
				.basicAuth("api", "b26a53756fd0c37ba9878b579da0db4a-77751bfc-f0a44072")
				.queryString("begin", "Mon, 16 Feb 2021 09:00:00 -0000")
				//.queryString("id", "KV14FN4RSd2jwZSVZz_-fg")
				.queryString("ascending", "yes")
				.queryString("limit", 10)
				.asJson();

		return request.getBody().getObject();
	}

	public static void main(String[] args) {
		SpringApplication.run(JavaMailgunApplication.class, args);

		ObjectMapper objectMapper  = new ObjectMapper();

		try {

			JSONObject jsonNode = getLogs();
			System.out.println(jsonNode);
//			IncomingEmailDeliveryStatusEvent incomingEmailDeliveryStatusEvent = objectMapper.readValue(jsonNode.toString(), IncomingEmailDeliveryStatusEvent.class);
//			JSONObject j = new JSONObject();
//			j.put("items", incomingEmailDeliveryStatusEvent.getItems());
//
//			System.out.println(j);

		} catch (UnirestException e) {
			e.printStackTrace();
		}
	}

}

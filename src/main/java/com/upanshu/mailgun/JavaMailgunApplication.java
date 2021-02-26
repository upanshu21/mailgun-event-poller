package com.upanshu.mailgun;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@SpringBootApplication
public class JavaMailgunApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(JavaMailgunApplication.class);

	public static String YOUR_DOMAIN_NAME = "sandboxf61208194e014fbda2d95be95385fc99.mailgun.org";

	public static JsonNode sendSimpleMessage() throws UnirestException {
		HttpResponse<JsonNode> request = Unirest.post("https://api.mailgun.net/v3/" + YOUR_DOMAIN_NAME + "/messages")
				.basicAuth("api", "708c1e9dce63aa82f53ac4974e5b0ed1-d32d817f-8cb3b0b7")
				.queryString("from", "MailgunTest tobby.singh101@gmail.com")
				.queryString("to", "upanshu21@gmail.com")
				.queryString("subject", "Offer from team Ackerman")
				.queryString("text", "Will you join the levi squad? Also sent from code, testing.")
				.asJson();
		return request.getBody();
	}


	public static void main(String[] args) throws UnirestException {
		SpringApplication.run(JavaMailgunApplication.class, args);
		//sendSimpleMessage();
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("Schdeuler started for poller integration");
	}
}

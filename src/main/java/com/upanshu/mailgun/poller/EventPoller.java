package com.upanshu.mailgun.poller;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.upanshu.mailgun.Repository.HttpClientImpl;
import com.upanshu.mailgun.processor.JsonProcessor;
import com.upanshu.mailgun.processor.PollerTimestampService;
import com.upanshu.mailgun.utils.PollerConstants;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class EventPoller {

    private static final Logger logger = LoggerFactory.getLogger(EventPoller.class);
    public static String YOUR_DOMAIN_NAME = "sandboxf61208194e014fbda2d95be95385fc99.mailgun.org";
//    int time = 1613979085;
//    BigDecimal epocTime = new BigDecimal(time);

    //public String uri = "https://api.mailgun.net/v3/sandboxf61208194e014fbda2d95be95385fc99.mailgun.org/events";


    private final HttpClientImpl httpClient;
    private final JsonProcessor jsonProcessor;
    private final PollerTimestampService pollerTimestampService;
    private final String uri;

    public EventPoller(HttpClientImpl httpClient, JsonProcessor jsonProcessor, PollerTimestampService pollerTimestampService, @Value("${config.url}") String uri) {
        this.httpClient = httpClient;
        this.jsonProcessor = jsonProcessor;
        this.pollerTimestampService = pollerTimestampService;
        this.uri = uri;
    }

    private String url;

    @Scheduled(fixedRate = 10000)
    public void getEventPagesAsJson() throws UnirestException {
        System.out.println(uri);

        //query mongo and update epoc
        System.out.println(url);
        String getUrl = jsonProcessor.getUrl(uri,url);
        BigDecimal epocTime = new BigDecimal(1614177751);
        JSONObject event = httpClient.getJsonData(getUrl, epocTime);
        System.out.println(event);
        BigDecimal timestamp = jsonProcessor.getTimeStampForLastEvent(event);
        int isItemsListEmpty = jsonProcessor.isTrustworthy(timestamp, PollerConstants.THRESHOLD);
        if(isItemsListEmpty == 0) {
            pollerTimestampService.insertLatestTimestampInDatabase();
            //update mongo timestamp and change url value to default
            logger.info("Timestamp updated in database");
            url = uri;
            logger.info("URL has been changed to default");
        } else {
            int checkIfTrustWorthy = jsonProcessor.isTrustworthy(timestamp, epocTime);
            if(checkIfTrustWorthy > 0) {
                logger.info("Received trustworthy event, processing further");
                // publish to rabbi
                url = jsonProcessor.getNextPageUrl(event);
            } else {
                logger.info("Received untrustworthy event, repeating previous request");
            }
        }
    }


}

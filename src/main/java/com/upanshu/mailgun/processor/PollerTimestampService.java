package com.upanshu.mailgun.processor;

import com.upanshu.mailgun.Repository.EventTimestampRepository;
import com.upanshu.mailgun.model.EventTimestamp;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;


@Component
public class PollerTimestampService {

    private final EventTimestampRepository eventTimestampRepository;

    public PollerTimestampService(EventTimestampRepository eventTimestampRepository) {
        this.eventTimestampRepository = eventTimestampRepository;
    }

    public  BigDecimal getTimestamp() {
        List<EventTimestamp> eventTimestamps = eventTimestampRepository.findAll();
        if(eventTimestamps.isEmpty()) {
            long currentTimeStamp = Instant.now().minus(1, ChronoUnit.DAYS).getEpochSecond();
            return new BigDecimal(currentTimeStamp);
        } else {
            return getTimeStampFromDb();
        }

    }

    public BigDecimal getTimeStampFromDb() {
        List<EventTimestamp> timestamp = eventTimestampRepository.findAll();
        int lengthOfList = timestamp.size();
        EventTimestamp get = timestamp.get(lengthOfList-1);
        return new BigDecimal(get.getTimestamp());
    }

    public void insertLatestTimestampInDatabase() {
        long currentTimeStamp = Instant.now().minus(1, ChronoUnit.MINUTES).getEpochSecond();
        EventTimestamp timestamp = new EventTimestamp(String.valueOf(currentTimeStamp));
        eventTimestampRepository.insert(timestamp);
    }

}

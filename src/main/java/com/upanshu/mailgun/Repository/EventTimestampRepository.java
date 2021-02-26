package com.upanshu.mailgun.Repository;

import com.upanshu.mailgun.model.EventTimestamp;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventTimestampRepository extends MongoRepository<EventTimestamp, String> {

}

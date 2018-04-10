package com.job.service;

import com.job.entity.Message;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface MessageRepository extends MongoRepository<Message, String> {

    Message findByTitle(String title);

}

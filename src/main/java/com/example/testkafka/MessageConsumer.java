package com.example.testkafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Source from test-kafka
 *
 * @author K_Kimiyabeigi
 * @since 1/2/2022 Copyright (c) 2022 isc.co.ir to present.
 */
@Component
@Slf4j
public class MessageConsumer {
  @Autowired private MessageRepository messageRepo;

  @KafkaListener(topics = "myKafkaTest", groupId = "groupTest")
  public void consume(String message) {
    log.info("MESSAGE RECEIVED AT CONSUMER END -> " + message);
    messageRepo.addMessage(message);
  }

  /*  @KafkaListener(topics = "${myapp.kafka.topic}", groupId = "xyz")
  public void consume(String message) {
    log.info("MESSAGE RECEIVED AT CONSUMER END -> " + message);
    messageRepo.addMessage(message);
  }*/
}

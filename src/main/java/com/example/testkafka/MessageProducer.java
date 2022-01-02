package com.example.testkafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * Source from test-kafka
 *
 * @author K_Kimiyabeigi
 * @since 1/2/2022 Copyright (c) 2022 isc.co.ir to present.
 */
@Component
@Slf4j
public class MessageProducer {
  @Autowired private KafkaTemplate<String, String> kafkaTemplate;
  @Autowired private NewTopic topicTest;

  public void sendMessage(String message) {
    log.info("MESSAGE SENT FROM PRODUCER END -> " + message);
    kafkaTemplate.send(topicTest.name(), message);
  }

  // Kafka is a fast stream processing platform.
  // Therefore, it's better to handle the results asynchronously
  // so that the subsequent messages do not wait for the result of the previous message.
  public void sendMessageAsync(String message) {
    ListenableFuture<SendResult<String, String>> future =
        kafkaTemplate.send(topicTest.name(), message);

    future.addCallback(
        new ListenableFutureCallback<SendResult<String, String>>() {
          @Override
          public void onSuccess(SendResult<String, String> result) {
            log.info(
                "Sent message=["
                    + message
                    + "] with offset=["
                    + result.getRecordMetadata().offset()
                    + "]");
          }

          @Override
          public void onFailure(Throwable ex) {
            log.info("Unable to send message=[" + message + "] due to : " + ex.getMessage());
          }
        });
  }
}

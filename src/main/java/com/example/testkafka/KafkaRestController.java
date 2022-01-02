package com.example.testkafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Source from test-kafka
 *
 * @author K_Kimiyabeigi
 * @since 1/2/2022 Copyright (c) 2022 isc.co.ir to present.
 */
@RestController
public class KafkaRestController {
  @Autowired private MessageProducer producer;
  @Autowired private MessageRepository messageRepo;

  // Send message to kafka
  @GetMapping("/send")
  public String sendMsg(@RequestParam("msg") String message) {
    producer.sendMessage(message);
    return "message: '" + message + "' sent successfully!";
  }

  // Send message to kafka
  @GetMapping("/send/async")
  public String sendMsgAsync(@RequestParam("msg") String message) {
    producer.sendMessageAsync(message);
    return "message: '" + message + "' sent successfully!";
  }

  // Read all messages
  @GetMapping("/getAll")
  public String getAllMessages() {
    return messageRepo.getAllMessages();
  }
}

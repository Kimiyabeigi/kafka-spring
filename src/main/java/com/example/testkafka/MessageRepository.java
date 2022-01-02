package com.example.testkafka;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Source from test-kafka
 *
 * @author K_Kimiyabeigi
 * @since 1/2/2022 Copyright (c) 2022 isc.co.ir to present.
 */
@Component
public class MessageRepository {
  private final List<String> list = new ArrayList<>();

  public void addMessage(String message) {
    list.add(message);
  }

  public String getAllMessages() {
    return list.toString();
  }
}

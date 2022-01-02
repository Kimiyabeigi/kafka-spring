package com.example.testkafka.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

/**
 * Source from test-kafka
 *
 * @author K_Kimiyabeigi
 * @since 1/2/2022 Copyright (c) 2022 isc.co.ir to present.
 */
@Configuration
public class KafkaTopicConfig {
  @Value(value = "${kafka.bootstrapAddress}")
  private String bootstrapAddress;

  @Bean
  public KafkaAdmin kafkaAdmin() {
    Map<String, Object> configs = new HashMap<>();
    configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
    return new KafkaAdmin(configs);
  }

  @Bean
  public NewTopic topicTests() {
    return new NewTopic("myKafkaTest", 1, (short) 1);
  }
}

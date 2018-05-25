package com.nearsoft.exercise.persistenceservice.messaging;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class Config {

    @Bean
    public Queue hello() {
        return new Queue("create-item");
    }

    @Profile("receiver")
    @Bean
    public Receiver receiver() {
        return new Receiver();
    }
}
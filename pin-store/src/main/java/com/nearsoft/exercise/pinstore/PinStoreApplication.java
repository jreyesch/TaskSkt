package com.nearsoft.exercise.pinstore;

import com.nearsoft.exercise.pinstore.messaging.Receiver;
import com.nearsoft.exercise.pinstorecommons.entities.Item;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class PinStoreApplication {

    public List<Item> persistedItems = new ArrayList<>();

	@Bean
	MessageListenerAdapter listenerAdapter(Receiver receiver) {
		return new MessageListenerAdapter(receiver, "receiveMessage");
	}
	public static void main(String[] args) {
		SpringApplication.run(PinStoreApplication.class, args);
	}
}

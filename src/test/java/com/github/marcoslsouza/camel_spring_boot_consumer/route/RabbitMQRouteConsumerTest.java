package com.github.marcoslsouza.camel_spring_boot_consumer.route;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class RabbitMQRouteConsumerTest {

	@InjectMocks
	RabbitMQRouteConsumer rabbitMQRouteConsumer;
	
	@Test
	void whenConfigureExpectedNoException() {
		assertDoesNotThrow(() -> this.rabbitMQRouteConsumer.configure());
	}
}

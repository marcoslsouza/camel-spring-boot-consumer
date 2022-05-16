package com.github.marcoslsouza.camel_spring_boot_consumer.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.springframework.context.annotation.Configuration;

import com.github.marcoslsouza.camel_spring_boot_consumer.config.DefaultErrorHandlerProcessor;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class RabbitMQRouteProducer extends RouteBuilder {

	private final DefaultErrorHandlerProcessor defaultErrorHandlerProcessor;
	
	@Override
	public void configure() throws Exception {
		
		JacksonDataFormat jsonDataFormat = new JacksonDataFormat();
		
		errorHandler(defaultErrorHandler()
				.log("Error in RabbitMQRouteProducer")
				.onExceptionOccurred(defaultErrorHandlerProcessor)
		);
		
		
	}
}

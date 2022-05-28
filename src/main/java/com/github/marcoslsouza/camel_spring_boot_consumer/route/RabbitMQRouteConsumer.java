package com.github.marcoslsouza.camel_spring_boot_consumer.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.context.annotation.Configuration;

import com.github.marcoslsouza.camel_spring_boot_consumer.config.DefaultErrorHandlerProcessor;
import com.github.marcoslsouza.camel_spring_boot_consumer.dto.EmployeeDTO;
import com.github.marcoslsouza.camel_spring_boot_consumer.service.EmployeeProcessor;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class RabbitMQRouteConsumer extends RouteBuilder {

	private final DefaultErrorHandlerProcessor defaultErrorHandlerProcessor;
	
	private final EmployeeProcessor employeeProcessor;
	
	@Override
	public void configure() throws Exception {
		
		errorHandler(defaultErrorHandler()
				.log("Error in RabbitMQRouteProducer")
				.onExceptionOccurred(defaultErrorHandlerProcessor)
		);
		
		from("{{application.rabbitmq.queue.employee}}")
			.unmarshal()
			.json(JsonLibrary.Jackson, EmployeeDTO.class)
			.process(employeeProcessor);
			
	}
}

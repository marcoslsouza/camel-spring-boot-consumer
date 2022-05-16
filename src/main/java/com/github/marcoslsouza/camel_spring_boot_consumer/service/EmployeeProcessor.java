package com.github.marcoslsouza.camel_spring_boot_consumer.service;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Service;

import com.github.marcoslsouza.camel_spring_boot_consumer.dto.EmployeeDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeProcessor implements Processor {@Override
	
	public void process(Exchange exchange) throws Exception {
	
		EmployeeDTO employeeDTO = exchange.getIn().getBody(EmployeeDTO.class);
		
		Thread.sleep(100);
		
		log.info("Processing queue, name: {} | Cargo: {}", employeeDTO.getName(), employeeDTO.getOffice());
	}
}

package com.xavo.finance.transactions.service;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xavo.finance.transactions.entities.Service;

@Slf4j
@RestController
@RequestMapping ("api/v1/services")
public record ServiceController (ServiceService customerService) {

	@PostMapping
	public void registerCustomer(@RequestBody ServiceRegistrationRequest serviceRegistrationRequest) {
		log.info("new service registration {}", serviceRegistrationRequest);
		customerService.registerService(serviceRegistrationRequest);
	}

	@GetMapping
	public ResponseEntity<List<Service>> getAllServices() {
		List<Service> banks = new ArrayList<Service>();

		customerService.getAllAccounts().forEach(banks::add);
		if (banks.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<>(banks, HttpStatus.OK);
	}
}

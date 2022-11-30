package com.xavo.finance.transactions.service;

import java.util.List;

import com.xavo.finance.transactions.entities.Service;

import lombok.AllArgsConstructor;

@org.springframework.stereotype.Service
@AllArgsConstructor
public class ServiceService {

	private ServiceRepository serviceRepository;
	
	public void registerService(ServiceRegistrationRequest request) {
		Service category = Service.builder()
				.name(request.name())
				.category(request.category())
				.build();
		serviceRepository.saveAndFlush(category);
	}
	
	public List<Service> getAllAccounts() {
		return serviceRepository.findAll();
	}

}

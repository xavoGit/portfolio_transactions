package com.xavo.finance.transactions.service;

import com.xavo.finance.transactions.entities.Category;

public record ServiceRegistrationRequest(

	String name,
	Category category) {
}
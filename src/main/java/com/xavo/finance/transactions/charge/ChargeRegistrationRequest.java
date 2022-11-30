package com.xavo.finance.transactions.charge;

import com.xavo.finance.transactions.entities.Service;

public record ChargeRegistrationRequest(
		
		Integer accountId,
		String description,
		String date,
		Float amount,
		Integer counterpart,
		Service service) {
}
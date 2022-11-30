package com.xavo.finance.transactions.charge;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.xavo.finance.common.Utility;
import com.xavo.finance.transactions.entities.Charge;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ChargeService {

	private ChargeRepository chargeRepository;
	
	private final Logger logger = LoggerFactory.getLogger(ChargeService.class);
	
	public void registerCharge(ChargeRegistrationRequest request) {
		Charge charge = new Charge();
		charge.setAccountId(request.accountId());
		charge.setDescription(request.description());
		charge.setDate(Utility.parseDate(request.date()));
		charge.setAmount(request.amount());
		charge.setCounterpart(request.counterpart());
		charge.setService(request.service());
		chargeRepository.saveAndFlush(charge);
	}
	
	public List<Charge> findAll() {
		return chargeRepository.findAll();
	}

	public List<Charge> findByAccountIdEqual(Integer accountId) {
		logger.info("findByAccountIdEqual: " + accountId);
		return chargeRepository.findByAccountIdEquals(accountId);
	}

}

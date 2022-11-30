package com.xavo.finance.transactions.charge;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xavo.finance.transactions.entities.Charge;

@Slf4j
@RestController
@RequestMapping ("api/v1/transactions/charges")
public record ChargeController (ChargeService chargeService) {

	@SuppressWarnings("rawtypes")
	@PostMapping
	public ResponseEntity<?> registerCharge(@RequestBody ChargeRegistrationRequest chargeRegistrationRequest) {
		log.info("new charge registration {}", chargeRegistrationRequest);
		ResponseEntity response;		
		if(chargeRegistrationRequest.accountId()!=0) {
			chargeService.registerCharge(chargeRegistrationRequest);
			response = new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			
		}
		return response;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping
	public ResponseEntity<List<Charge>> getByAccountId(@RequestParam Integer accountId) {
		List<Charge> charges = new ArrayList<Charge>();
		ResponseEntity response;

		chargeService.findByAccountIdEqual(accountId).forEach(charges::add);
		if (charges.isEmpty()) {
			response =  new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			response = new ResponseEntity<>(charges, HttpStatus.OK);
		}

		return response;
	}
}

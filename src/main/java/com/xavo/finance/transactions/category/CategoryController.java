package com.xavo.finance.transactions.category;

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

import com.xavo.finance.transactions.entities.Category;

@Slf4j
@RestController
@RequestMapping ("api/v1/categories")
public record CategoryController (CategoryService customerService) {

	@PostMapping
	public void registerCustomer(@RequestBody CategoryRegistrationRequest categoryRegistrationRequest) {
		log.info("new category registration {}", categoryRegistrationRequest);
		customerService.registerCategory(categoryRegistrationRequest);
	}

	@GetMapping
	public ResponseEntity<List<Category>> getAllCategories() {
		List<Category> banks = new ArrayList<Category>();

		customerService.getAllAccounts().forEach(banks::add);
		if (banks.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<>(banks, HttpStatus.OK);
	}
}

package com.xavo.finance.transactions.category;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xavo.finance.transactions.entities.Category;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoryService {

	private CategoryRepository categoryRepository;
	
	public void registerCategory(CategoryRegistrationRequest request) {
		Category category = Category.builder()
				.name(request.name())
				.build();
		categoryRepository.saveAndFlush(category);
	}
	
	public List<Category> getAllAccounts() {
		return categoryRepository.findAll();
	}

}

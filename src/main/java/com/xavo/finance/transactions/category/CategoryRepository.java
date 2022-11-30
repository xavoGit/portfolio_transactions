package com.xavo.finance.transactions.category;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xavo.finance.transactions.entities.Category;

public interface CategoryRepository  extends JpaRepository<Category, Integer>{

}

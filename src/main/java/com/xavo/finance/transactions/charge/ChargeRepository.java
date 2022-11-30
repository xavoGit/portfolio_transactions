package com.xavo.finance.transactions.charge;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xavo.finance.transactions.entities.Charge;

public interface ChargeRepository  extends JpaRepository<Charge, Integer>{
	List<Charge> findByAccountIdEquals(Integer accountId);
}

package com.xavo.finance.transactions.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xavo.finance.transactions.entities.Service;

public interface ServiceRepository  extends JpaRepository<Service, Integer>{

}

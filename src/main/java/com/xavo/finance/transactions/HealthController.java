package com.xavo.finance.transactions;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("health")
public record HealthController () {

	@GetMapping
	public ResponseEntity<Map<String, String>> registerCustomer() throws UnknownHostException {
		Map<String, String> status= new Hashtable<String, String>();
		status.put("host", InetAddress.getLocalHost().getHostAddress());
		status.put("name", InetAddress.getLocalHost().getHostName());
		return new ResponseEntity<>(status , HttpStatus.OK);
	}
}

package com.anddigital.ktimucin.challenge.testanddigitalktimucin.phones;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhonesController {

	@Autowired
	PhoneDAO phoneDAO;
	
	@GetMapping("phones")
	public Set<String> retrieveAllPhones() {
		return phoneDAO.retrieveAllPhones();
	}
	
	@GetMapping("customers/{id}/phones")
	public void retrieveAllPhones(@PathVariable String id) {
		return;
	}
	
}

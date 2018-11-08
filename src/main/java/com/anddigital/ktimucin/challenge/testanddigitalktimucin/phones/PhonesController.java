package com.anddigital.ktimucin.challenge.testanddigitalktimucin.phones;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhonesController {

	@Autowired
	PhoneDAO phoneDAO;
	
	//GET /phones
	@GetMapping("phones")
	public Set<String> retrieveAllPhones() {
		return phoneDAO.retrieveAllPhones();
	}
	
	//GET /customers/{id}/phones
	@GetMapping("customers/{id}/phones")
	public List<String> retrieveAllPhones(@PathVariable String id) {
		return phoneDAO.retrievePhonesofCustomer (id);
		
	}
	
	//POST /phones/activate body--string
	@PostMapping("phones/activate")
	public String activatePhone(@RequestBody String phone) {
		return phoneDAO.activatePhone(phone);
	}
	
}

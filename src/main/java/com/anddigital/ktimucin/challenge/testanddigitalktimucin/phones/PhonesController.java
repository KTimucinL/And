package com.anddigital.ktimucin.challenge.testanddigitalktimucin.phones;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhonesController {

	@GetMapping("phones")
	public void retrieveAllPhones() {
		return;
	}
	
}

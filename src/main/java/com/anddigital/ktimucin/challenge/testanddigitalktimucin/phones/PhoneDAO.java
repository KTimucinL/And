package com.anddigital.ktimucin.challenge.testanddigitalktimucin.phones;

import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.anddigital.ktimucin.challenge.testanddigitalktimucin.phones.helper.PhonesDataHelper;

@Component
public class PhoneDAO {

	//2 collections will be used to keep phones, activity status, and customers
	//A helper function will be used to populate initial data.
	
	//HaspMap for phones, and activity
	
	private static Map<String,Boolean> phones =PhonesDataHelper.retrievePhones();
	
	public Set<String> retrieveAllPhones() {
		return phones.keySet();
		
	}

}

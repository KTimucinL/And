package com.anddigital.ktimucin.challenge.testanddigitalktimucin.phones.helper;

import java.util.HashMap;
import java.util.Map;

public class PhonesDataHelper {

	public static Map<String, Boolean> retrievePhones() {
		
		//some of the phones are already activate to test fail case for post active.
		Map<String, Boolean> phones = new HashMap<String,Boolean>();
		phones.put("7777-123456", false);
		phones.put("7777-111111", true);
		phones.put("7575-123456", false);
		phones.put("7575-111111", true);
		phones.put("7171-123456", false);
		phones.put("7171-111111", true);
		return phones;
	}
	
	

}

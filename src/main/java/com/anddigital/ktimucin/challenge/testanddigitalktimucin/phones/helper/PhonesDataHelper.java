package com.anddigital.ktimucin.challenge.testanddigitalktimucin.phones.helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

	//retrun phones and customers
	public static Map<String, List<String>> retrievePhonesofCustomers() {
		
		Map<String, List<String>> phonesOfCustomers = new HashMap<String,List<String>>();
		List<String> customer1 = new ArrayList<String>() ;
		customer1.add("7777-123456");
		customer1.add("7777-111111");
		
		List<String> customer2 = new ArrayList<String>() ;
		customer2.add("7575-123456");
		customer2.add("7575-111111");
		
		List<String> customer3 = new ArrayList<String>() ;
		customer3.add("7171-123456");
		customer3.add("7171-111111");
		
		phonesOfCustomers.put("1", customer1);
		phonesOfCustomers.put("2", customer2);
		phonesOfCustomers.put("3", customer3);
		
		return phonesOfCustomers;
	}
	
	

}

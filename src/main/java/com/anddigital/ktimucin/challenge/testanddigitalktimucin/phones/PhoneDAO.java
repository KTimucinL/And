package com.anddigital.ktimucin.challenge.testanddigitalktimucin.phones;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.expression.spel.support.BooleanTypedValue;
import org.springframework.stereotype.Component;

import com.anddigital.ktimucin.challenge.testanddigitalktimucin.phones.exception.CustomerNotFoundException;
import com.anddigital.ktimucin.challenge.testanddigitalktimucin.phones.exception.NoPhoneFoundException;
import com.anddigital.ktimucin.challenge.testanddigitalktimucin.phones.exception.PhoneAlreadyActiveException;
import com.anddigital.ktimucin.challenge.testanddigitalktimucin.phones.helper.PhonesDataHelper;

@Component
public class PhoneDAO {

	//2 collections will be used to keep phones, activity status, and customers
	//A helper function will be used to populate initial data.
	
	//HaspMap for phones, and activity
	
	private static Map<String,Boolean> phones =PhonesDataHelper.retrievePhones();
	
	//HashMap for customers and phones
	private static Map<String,List<String>> phonesOfCustomers =PhonesDataHelper.retrievePhonesofCustomers();
	
	public Set<String> retrieveAllPhones() {
		return phones.keySet();
		
	}

	public List<String> retrievePhonesofCustomer(String id) {
	
		//Check whether any phones for customer exists.
		if(!phonesOfCustomers.containsKey(id))
			throw new CustomerNotFoundException("No valid customer id: " + id);
		
		return phonesOfCustomers.get(id);
		
	}

	public String activatePhone(String phone) {
		//Check phone number
		if(!phones.containsKey(phone)) {
			throw new NoPhoneFoundException("No valid  phone number: " + phone);
		}
			
		Boolean isActive= phones.get(phone);
		//Check already active or not
		if(isActive) {
			throw new PhoneAlreadyActiveException("Phone is already active!: " + phone);
		}
		
		//Activate phone
		phones.put(phone, Boolean.TRUE);
		
		
		return phone;
	}

}

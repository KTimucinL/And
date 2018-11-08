package com.anddigital.ktimucin.challenge.testanddigitalktimucin;

import static org.junit.Assert.assertTrue;

import javax.validation.constraints.AssertTrue;

import org.hamcrest.core.IsNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;
import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestAnddigitalKtimucinApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	//check whether /phones endpoint is up.
	@Test
	public void testGetPhonesEndPoint() {
		
		RestAssured.baseURI="http://localhost:8080";
		
		RestAssured.given().when().get("phones").
					then().assertThat().statusCode(200);
		
		
	}
	//check whether get phones is returning empty or not.
	//Aim is create DAO and return proper phones
		@Test
		public void testGetPhonesAList() {
			
			RestAssured.baseURI="http://localhost:8080";
			
			String phones = RestAssured.given().when().get("phones").
						then().assertThat().statusCode(200)
						.and().extract().response().asString();
			assertTrue(!phones.equalsIgnoreCase(""));
			
			System.out.println("---------------All Phones----------"+phones);
		}
		
		//check whether get phones of customer is up or not.
			@Test
			public void testGetPhonesOfCustomer() {
				
				RestAssured.baseURI="http://localhost:8080";
				
				RestAssured.given().when().
						pathParam("id", "1")
						.get("customers/{id}/phones").
							then().assertThat().statusCode(200);
				
			}
			
			//check whether get phones is returning empty or not.
			//Aim is create DAO and return proper phones
			@Test
			public void testGetPhonesOfCustomerList() {
				
				RestAssured.baseURI="http://localhost:8080";
				
				String phonesOf1 = RestAssured.given().when().
						pathParam("id", "1")
						.get("customers/{id}/phones").
							then().assertThat().statusCode(200).and().extract().response().asString();
				assertTrue(!phonesOf1.equalsIgnoreCase(""));
				
				System.out.println("---------------All Phones for customer id 1----------"+phonesOf1);
				
			}
			
			@Test
			public void testGetPhonesOfWrongCustomerEndPoint() {
				RestAssured.baseURI="http://localhost:8080";
				
				RestAssured.given().
						pathParam("id", "XX")
						.get("customers/{id}/phones").
						then().assertThat().statusCode(404);
				
				
			}
			
			
			

}

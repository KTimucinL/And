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
			
			//404 expected.
			@Test
			public void testGetPhonesOfWrongCustomerEndPoint() {
				RestAssured.baseURI="http://localhost:8080";
				
				RestAssured.given().
						pathParam("id", "XX")
						.get("customers/{id}/phones").
						then().assertThat().statusCode(404);
				
				
			}
			
			//Activate
			@Test
			public void testActivatePhone() {
				RestAssured.baseURI="http://localhost:8080";
				String phone="7777-123456";
				String activated= RestAssured.given().
						body(phone)
						.post("phones/activate").
						then().assertThat().statusCode(200).and().extract().response().asString();;
						assertTrue(activated.equalsIgnoreCase(phone));
						
						System.out.println("---------------Phones activated----------"+activated);
				
				
			}
			
			//Expect 404
			@Test
			public void testWrongPhone() {
				RestAssured.baseURI="http://localhost:8080";
				String phone="7777-1233456";
				RestAssured.given().
						body(phone)
						.post("phones/activate").
						then().log().all().assertThat().statusCode(404);
						
				
			}
			
			//Expect 400
			@Test
			public void testAlreadyActivatePhone() {
				RestAssured.baseURI="http://localhost:8080";
				String phone="7777-111111";
				RestAssured.given().
						body(phone)
						.post("phones/activate").
						then().log().all().assertThat().statusCode(400);
						
				
				
			}

}

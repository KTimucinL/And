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
	
	//Just check whether /phones endpoint is up.
	@Test
	public void testGetPhonesEndPoint() {
		
		RestAssured.baseURI="http://localhost:8080";
		
		RestAssured.given().when().get("phones").
					then().assertThat().statusCode(200);
		
		
	}
	//Just check whether get phones is returning empty or not.
	//Aim is create DAO and return proper phones
		@Test
		public void isGetPhonesAList() {
			
			RestAssured.baseURI="http://localhost:8080";
			
			String phones = RestAssured.given().when().get("phones").
						then().assertThat().statusCode(200)
						.and().extract().response().asString();
			assertTrue(!phones.equalsIgnoreCase(""));
			
			
		}

}

package com.anddigital.ktimucin.challenge.testanddigitalktimucin;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;

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

}

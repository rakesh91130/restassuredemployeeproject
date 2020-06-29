package com.rakesh.employeeapi.testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.rakesh.employeeapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class GetAllEmployees extends TestBase{
	
	@BeforeClass
	void getAllEmployees() throws InterruptedException{
		logger.info("*********Started getAllEployees********");
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		httpRequest=RestAssured.given();
		response=httpRequest.request(Method.GET,"/employees");
		
		Thread.sleep(3);
	}
	
	@Test
	void checkingResponseBody() {
		logger.info("*********checking Response Body********");
		String responseBody=response.getBody().asString();
		logger.info("Response body==> "+responseBody);
		Assert.assertTrue(responseBody!=null);
	}

	
}


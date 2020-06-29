package com.rakesh.employeeapi.base;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBase {

	public static RequestSpecification httpRequest;
	public static Response response;
	public String empID="5223";//input for Get details of single employee
	
	public Logger logger;
	
	
	/*
	 * setUp method will execute first due to BeforeClass annotation
	 * setUp method will generate log
	 */
	@BeforeClass
	public void setUp() {
		logger=Logger.getLogger("Employee RestApi");
		PropertyConfigurator.configure("Log4j.properties");//property file location
		logger.setLevel(Level.DEBUG);
		
	}
	
}

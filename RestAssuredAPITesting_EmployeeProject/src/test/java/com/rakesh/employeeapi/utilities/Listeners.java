package com.rakesh.employeeapi.utilities;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listeners extends TestListenerAdapter{

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	public void onStart(ITestContext testContext) {
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test_output/myreport.html");
		htmlReporter.config().setDocumentTitle("AutomationReport");//Title of report
		htmlReporter.config().setReportName("FunctionalReport");//Name of report
		htmlReporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("hostName", "localHost");
		extent.setSystemInfo("tester", "rakesh");
		extent.setSystemInfo("Browswr", "Chrome");	
	}
	
	public void onTestSuccess(ITestResult result) {
		test=extent.createTest(result.getName());//Create new entry in the report
		test.log(Status.PASS, "Test case passed is "+result.getName());//To add name in the extent report
		
	}
	public void onTestSkipped(ITestResult result) {
		test=extent.createTest(result.getName());//Create new entry in the report
		test.log(Status.SKIP, "Test case passed is "+result.getName());//To add name in the extent report
		
	}
		
	public void onTestFailure(ITestResult result) {
		test=extent.createTest(result.getName());//Create new entry in the report
		test.log(Status.FAIL, "Test case passed is "+result.getName());//To add name in the extent report
		test.log(Status.FAIL, "Test case passed is "+result.getThrowable());//To add error/exception in the extent report
		
	}
	
	public void onFinish(ITestContext testContext) {
		extent.flush();		
	}
	
}

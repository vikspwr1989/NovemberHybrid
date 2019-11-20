package com.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.reports.ReportGenerator;
import com.testbase.TestBase;
import com.utils.TestUtils;

public class TestListener extends TestBase implements ITestListener{

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		ReportGenerator.verifyTest("FAIL", "Expected Result : "+result.getName()+" should be verified <br /> Actual Result : "+result.getName()+" has not verified - Test Failed", TestUtils.getScreenshot(result.getName()));
		
	}

	public void onTestSkipped(ITestResult result) {
		
		ReportGenerator.verifyTest("SKIP", "Expected Result : "+result.getName()+" should be verified <br /> Actual Result : "+result.getName()+" has not verified - Test Skipped", TestUtils.getScreenshot(result.getName()));
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		
		ReportGenerator.startTest(context.getName());
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}

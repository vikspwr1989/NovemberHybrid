package com.reports;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.testbase.TestBase;

public class ReportGenerator extends TestBase{
	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports reports;
	public static ExtentTest test;
	
	public static void generateReport(String reportName,String docTitle)
	{
		htmlReporter = new ExtentHtmlReporter("src/test/resources/HTMLReport/"+reportName+".html");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
		
		htmlReporter.config().setDocumentTitle(docTitle);
		htmlReporter.config().setReportName("GCR Shop");
		
		reports.setSystemInfo("Env", "QA");
		reports.setSystemInfo("OS", System.getProperty("os.name"));
		reports.setSystemInfo("QA", "Vikas");
	}
	
	public static void endReport()
	{
		
		reports.flush();
		
	}
	
	public static void startTest(String testName)
	{
		test = reports.createTest(testName);
	}
	
	public static void verifyTest(String status,String text,String screenShot)
	{
		if(status.equalsIgnoreCase("PASS"))
		{
			test.pass(MarkupHelper.createLabel(text, ExtentColor.GREEN));
		}
		else if(status.equalsIgnoreCase("FAIL"))
		{
			test.fail(MarkupHelper.createLabel(text, ExtentColor.RED));
			try {
				test.fail("For Failed test Screenshot. Click below",MediaEntityBuilder.createScreenCaptureFromPath(screenShot).build());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(status.equalsIgnoreCase("SKIP"))
		{
			test.skip(MarkupHelper.createLabel(text, ExtentColor.YELLOW));
			try {
				test.skip("For Skipped test Screenshot. Click below",MediaEntityBuilder.createScreenCaptureFromPath(screenShot).build());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

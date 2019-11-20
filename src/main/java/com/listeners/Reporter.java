package com.listeners;

import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.xml.XmlSuite;

import com.testbase.TestBase;

public class Reporter extends TestBase implements IReporter{

	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		
		for (ISuite iSuite : suites) {
			
			Map<String, ISuiteResult> map = iSuite.getResults();
			
			for(ISuiteResult rs : map.values())
			{
				ITestContext tc = rs.getTestContext();
				System.out.println(tc.getAllTestMethods().length);
				System.out.println(tc.getPassedTests().size());
				System.out.println(tc.getFailedTests().size());
				System.out.println(tc.getSkippedTests().size());
			}
		}
		
	}

}

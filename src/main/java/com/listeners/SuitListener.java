package com.listeners;

import java.sql.Date;

import org.testng.ISuite;
import org.testng.ISuiteListener;

import com.reports.ReportGenerator;
import com.testbase.TestBase;

public class SuitListener extends TestBase implements ISuiteListener{

	public void onStart(ISuite suite) {
		
		ReportGenerator.generateReport(System.currentTimeMillis()+"", "GCR Shop");
		
	}

	public void onFinish(ISuite suite) {
		ReportGenerator.endReport();
		
	}

}

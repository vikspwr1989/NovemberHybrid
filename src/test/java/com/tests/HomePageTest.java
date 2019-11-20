package com.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.LoginPage;
import com.reports.ReportGenerator;
import com.testbase.TestBase;

public class HomePageTest extends TestBase{
	
	public static By txtCustomers = By.xpath("//td[contains(text(),'Customers')]");
	public static By txtOrders = By.xpath("//td[contains(text(),'Orders')]");
	public static By lnkOrders = By.xpath("//a[text()='Orders']");
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		
		init();
		loginPage = new LoginPage();
		homePage = loginPage.loginToGCR(properties.getProperty("username"), properties.getProperty("password"));
		
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		
			driver.close();
			
	}
	
	@Test(priority=1)
	public void verifyCustomersLink()
	{
		homePage.customersLink();
		
		boolean status = driver.findElement(txtCustomers).isDisplayed();
		Assert.assertTrue(status);
		
		
		ReportGenerator.verifyTest("PASS", "Expected Result : Should be redirected to Customers Page <br /> Actual Result : Redirected to Customers Page", "");
		
		
	}
	
	@Test(priority=2)
	public void verifyOrdersLink()
	{
		
		//homePage.ordersLink();
		
		
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", driver.findElement(lnkOrders));
		
		boolean status = driver.findElement(txtOrders).isDisplayed();
		Assert.assertTrue(status);
		System.out.println(status);
		
		
		ReportGenerator.verifyTest("PASS", "Expected Result : Should be redirected to Orders Page <br /> Actual Result : Redirected to Orders Page", "");
		
		
	}
	
	

}

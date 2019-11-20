package com.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.LoginPage;
import com.testbase.TestBase;

public class CustomersPageTest extends TestBase{
	
	public CustomersPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		
		init();
		loginPage = new LoginPage();
		homePage = loginPage.loginToGCR(properties.getProperty("username"), properties.getProperty("password"));
		customersPage = homePage.customersLink();
		
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		
			driver.close();
			
	}
	
	@Test
	public void verifyGetAllCustomersSize()
	{
		customersPage.getAllCustomersSize();
		
	}
	
	

}

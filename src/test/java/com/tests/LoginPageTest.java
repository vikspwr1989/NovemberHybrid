package com.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pages.LoginPage;
import com.reports.ReportGenerator;
import com.testbase.TestBase;
import com.utils.TestUtils;

public class LoginPageTest extends TestBase{
	
	public static By isDisplay = By.linkText("Logoff");
	public static By errorMsg = By.xpath("//td[@class='messageStackError']");
	public static int count;
	
	public LoginPageTest() {
		
		super();
		
	}
	
	@Test(priority=1)
	public void verifyGetTitle()
	{
		//ReportGenerator.startTest("Verify Title");
		String actualTitle = loginPage.getTitle();
		Assert.assertEquals(actualTitle, properties.getProperty("ExpectedTitle"),"Login Page Title Not Verified");
		ReportGenerator.verifyTest("PASS", "Expected Title : GCR Shop <br /> Actual Title : "+actualTitle+"", "");
	}
	
	@DataProvider
	public static Object[][] fetchData()
	{
		//System.out.println(TestUtils.getData("GCRLogin").toString());
		return TestUtils.getData("GCRLogin");
	}
	
	@Test(priority=2,dataProvider = "fetchData")
	public void verifyLoginToGCR(String uname,String pass)
	{
		count++;
		
		homePage = loginPage.loginToGCR(uname,pass);
		
			if(count==1)
			{
				Assert.assertTrue(driver.findElement(isDisplay).isDisplayed(),"Login To Application Not Verified");
				ReportGenerator.verifyTest("PASS", "For Valid Details - Username : "+uname+" and Password : "+pass+" <br /> Expected Result : Should be Login to GCR App <br /> Actual Result : Logged in to GCR App", "");
			}
			
			if(count==2)
			{
				Assert.assertTrue(driver.findElement(errorMsg).isDisplayed(),"Login To Application Not Verified");
				ReportGenerator.verifyTest("PASS", "For Invalid Details - Username : "+uname+" and Password : "+pass+" <br /> Expected Result : Error Message Should be displayed <br /> Actual Result : Error Message displayed", "");
			}
			
	}
	
	
	@BeforeMethod
	public void setup()
	{
		
		init();
		loginPage = new LoginPage();
	}
	
	@AfterMethod
	public void tearDown()
	{
		if(driver!=null)
		{
			driver.quit();
		}
		
		
	}

}

package com.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.pages.CustomersPage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.utils.TestUtils;

public class TestBase {
	
	static public FileInputStream fis;
	static public Properties properties;
	static public WebDriver driver;
	
	static public LoginPage loginPage;
	static public HomePage homePage;
	static public CustomersPage customersPage;
	
	public TestBase() {
		
		try {
			fis = new FileInputStream("src/test/resources/or.properties");
			properties = new Properties();
			properties.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void init()
	{
		if(properties.getProperty("browserName").equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","D:\\Selenium\\drivers\\MyDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		else if(properties.getProperty("browserName").equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.chrome.driver","D:\\Selenium\\drivers\\MyDrivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			
		}
		else
		{
			System.out.println("Invalid Browser...");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtils.EXPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(properties.getProperty("url"));
	}

}

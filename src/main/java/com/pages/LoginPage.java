package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.testbase.TestBase;

public class LoginPage extends TestBase{
	
	public LoginPage() {
		
			PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(how=How.NAME,using="username")
	@CacheLookup
	WebElement txtUsername;
	
	@FindBy(how=How.NAME,using="password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(how=How.ID,using="tdb1")
	@CacheLookup
	WebElement btnLogin;
	
	
	public String getTitle()
	{
		return driver.getTitle();
	}
	
	public HomePage loginToGCR(String username,String password)
	{
		txtUsername.sendKeys(username);
		txtPassword.sendKeys(password);
		btnLogin.click();
		return new HomePage();
	}

}

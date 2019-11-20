package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.testbase.TestBase;

public class HomePage extends TestBase{
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.LINK_TEXT,using="Customers")
	@CacheLookup
	WebElement lnkOuterCustomers;
	
	
	@FindBy(how=How.XPATH,using="(//a[text()='Customers'])[2]")
	@CacheLookup
	WebElement lnkInnerCustomers;
	
	@FindBy(how=How.XPATH,using="(//a[contains(text(),'Orders')])[1]")
	@CacheLookup
	WebElement lnkOrders;
	
	
	
	public CustomersPage customersLink()
	{
		lnkOuterCustomers.click();
		lnkInnerCustomers.click();
		return new CustomersPage();
	}
	
	public OrdersPage ordersLink()
	{
		//lnkOuterCustomers.click();
		lnkOrders.click();
		return new OrdersPage();
	}
	
	

}

package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.testbase.TestBase;

public class OrdersPage extends TestBase{
	
	public OrdersPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	

}

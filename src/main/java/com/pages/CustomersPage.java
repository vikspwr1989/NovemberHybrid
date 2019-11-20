package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.testbase.TestBase;

public class CustomersPage extends TestBase{
	
	public CustomersPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void getAllCustomersSize()
	{
		       
		
			String total = driver.findElement(By.xpath("(//td[@class='smallText'])[2]")).getText().split(" ")[5];
			System.out.println(total);
		
	}
	
	
	
	

}
